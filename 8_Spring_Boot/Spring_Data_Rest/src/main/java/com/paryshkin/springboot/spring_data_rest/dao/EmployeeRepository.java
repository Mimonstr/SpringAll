package com.paryshkin.springboot.spring_data_rest.dao;

import com.paryshkin.springboot.spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Spring Boot теперь все делает за нас(не нужно создавать методы и класс, который их реализует)
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    public List<Employee> findAllByName(String name);//Нужно корректно задавать название метода и параметры
}
