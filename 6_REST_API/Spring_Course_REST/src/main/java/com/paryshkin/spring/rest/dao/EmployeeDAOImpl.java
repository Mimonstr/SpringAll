package com.paryshkin.spring.rest.dao;

import com.paryshkin.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//используется для DAO для регистрации компонентов в спринг контейнер
public class EmployeeDAOImpl implements EmployeeDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
                .getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        Session session = sessionFactory.getCurrentSession();
        //session.saveOrUpdate(employee);//Устаревший метод

        session.merge(employee); // Для обновления или создания

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
    }

    @Override
    public Employee getEmployee(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id)
    {
        Session session = sessionFactory.getCurrentSession();
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        //ОБНОВЛЕННЫЙ КОД:
        session.createMutationQuery("delete from Employee where id =:employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();


    }

}
