package com.paryshkin.spring.mvc_hibernate_aop.dao;

import com.paryshkin.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    public List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
