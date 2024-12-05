package com.paryshkin.spring.rest;

import com.paryshkin.spring.rest.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empById = communication.getEmployee(3);
//        System.out.println(empById);

//        Employee emp = new Employee("Sveta", "Sokolova", "IT", 1200);
//        emp.setId(11);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(11);
    }
}
