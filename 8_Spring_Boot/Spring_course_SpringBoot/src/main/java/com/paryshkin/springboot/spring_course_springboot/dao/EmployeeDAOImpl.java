package com.paryshkin.springboot.spring_course_springboot.dao;


import com.paryshkin.springboot.spring_course_springboot.entity.Employee;


import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//используется для DAO для регистрации компонентов в спринг контейнер
public class EmployeeDAOImpl implements EmployeeDAO
{
    @Autowired
    private EntityManager entityManager;//JPA

    @Override
    public List<Employee> getAllEmployees()
    {
        //Hibernate:
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
//                .getResultList();

        //JPA:
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();


        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        //Hibernate:
//        Session session = entityManager.unwrap(Session.class);
//        //session.saveOrUpdate(employee);//Устаревший метод
//
//        session.merge(employee); // Для обновления или создания

        //ИЛИ ТАК:
        /*
        if (employee.getId() == null)
        {
            // Если объект новый, используйте persist
            session.persist(employee);
         }
         else
         {
            // Если объект уже существует, используйте merge
            session.merge(employee);
         }
         */


        //JPA:
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id)
    {
        //Hibernate:
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        //JPA:
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id)
    {
        //Hibernate:
//        Session session = entityManager.unwrap(Session.class);
////        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
////        query.setParameter("employeeId", id);
////        query.executeUpdate();
//
//        //ОБНОВЛЕННЫЙ КОД:
//        session.createMutationQuery("delete from Employee where id =:employeeId")
//                .setParameter("employeeId", id)
//                .executeUpdate();

        //JPA:
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }

}
