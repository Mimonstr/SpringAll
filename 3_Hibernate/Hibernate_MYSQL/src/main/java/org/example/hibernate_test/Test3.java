package org.example.hibernate_test;

import org.example.hibernate_test.entitty.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3
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
            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
            /**
             * Получаем работника из БД
             */
            //Получаем всех работников
//            List<Employee> emps = session.createQuery("from Employee").getResultList();//Работаем с самим классом
            //Подчеркивание красным это не ошибка

            //Получаем работника с именем Alexander
//            List<Employee> emps = session.createQuery("from Employee where name = 'Alexander'")
//                    .getResultList();//Работаем с самим классом

            //Получаем работника с фамилией Иванов и зп > 650
            List<Employee> emps = session.createQuery("from Employee where surname = 'Ivanov'" +
                            "AND salary > 650")
                    .getResultList();

            for (Employee employee: emps)
            {
                System.out.println(employee);
            }

            session.getTransaction().commit();//закрываем сессию(делаем коммит)


            System.out.println("Done!");

        }
        finally
        {
            factory.close();
        }
    }
}
