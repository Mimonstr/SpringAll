package org.example.hibernate_test;

import org.example.hibernate_test.entitty.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5
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
//            Удаляем полученного работника:
//            session.delete(employee);

            //Хотим удалить несколько строк
            session.createQuery("delete Employee " +
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
