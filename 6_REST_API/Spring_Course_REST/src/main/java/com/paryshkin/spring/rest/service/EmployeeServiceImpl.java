package com.paryshkin.spring.rest.service;

import com.paryshkin.spring.rest.dao.EmployeeDAO;
import com.paryshkin.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service//является соединительным звеном между контроллером и DAO
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional//не беспокоимся об открытии и закрытии транзакций
    public List<Employee> getAllEmployees()
    {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee)
    {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id)
    {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id)
    {
        employeeDAO.deleteEmployee(id);
    }
}
