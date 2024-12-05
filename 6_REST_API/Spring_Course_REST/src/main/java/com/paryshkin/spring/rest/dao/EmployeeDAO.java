package com.paryshkin.spring.rest.dao;

import com.paryshkin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    public List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
