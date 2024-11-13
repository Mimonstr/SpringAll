package org.example.hibernate_test;

import org.example.hibernate_test.entitty.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();//знает как должны создаваться сессии

        try
        {
            Session session = factory.getCurrentSession();//Подключение к базе
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(1500);//Меняем значение java объекта и это отображается в таблице, так как они связаны

            //Меняем ЗП у всех Александров
            session.createQuery("update Employee set salary = 1000 " +
                    "where name = 'Alexander'").executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");

        }
        finally
        {
            factory.close();
        }
    }
}
