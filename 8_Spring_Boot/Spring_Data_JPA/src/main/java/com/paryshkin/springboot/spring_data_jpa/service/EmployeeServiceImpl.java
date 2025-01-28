package com.paryshkin.springboot.spring_data_jpa.service;

import com.paryshkin.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.paryshkin.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service//является соединительным звеном между контроллером и DAO
public class EmployeeServiceImpl implements EmployeeService
{
    //@Transactional можно убрать у всех методов
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();//Пользуемся методами Spring Boot
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id)
    {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent())
        {
            employee = optionalEmployee.get();
        }
        return employee;

        //Или так:
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        // Если сотрудник найден, возвращаем его, иначе выбрасываем исключение
//        return optionalEmployee.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }



    @Override
    public void deleteEmployee(int id)
    {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name)
    {
        return employeeRepository.findAllByName(name);
    }
}
