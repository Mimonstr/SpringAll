package com.paryshkin.spring.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/employee")
public class MyController
{

    @RequestMapping("/")
    public String showFirstView()
    {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model)
    {
        Employee employee = new Employee();
        //employee.setName("Ivan");
        //employee.setSurname("Ivanov");
        //employee.setSalary(100);
        model.addAttribute("employee", employee);
        return "ask-emp-details-view";
    }


//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model)
//    {
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//
//        return "show-emp-details-view";
//    }


    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult)
    {
//        System.out.println("surname length = " + emp.getSurname().length());
        if(bindingResult.hasErrors())
        {
            return "ask-emp-details-view";
        }
        else
        {
            return "show-emp-details-view";
        }
    }
}
