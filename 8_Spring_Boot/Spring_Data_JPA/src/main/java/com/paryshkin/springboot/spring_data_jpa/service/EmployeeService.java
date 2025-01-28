package com.paryshkin.springboot.spring_data_jpa.service;

import com.paryshkin.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);
    void deleteEmployee(int id);

    List<Employee> findAllByName(String name);
}
