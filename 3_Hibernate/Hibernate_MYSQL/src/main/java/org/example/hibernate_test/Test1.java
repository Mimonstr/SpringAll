package org.example.hibernate_test;

import org.example.hibernate_test.entitty.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1
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

            Employee emp = new Employee("Alexander", "Ivanov", "IT", 600);

            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)

            session.save(emp);//Заинсертили объект в базу и закрываем сессию(делаем коммит)
            session.getTransaction().commit();
            System.out.println("Done!");
            System.out.println(emp);
        }
        finally
        {
            factory.close();
        }
    }
}
