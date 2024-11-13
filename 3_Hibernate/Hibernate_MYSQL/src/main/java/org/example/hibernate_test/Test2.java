package org.example.hibernate_test;

import org.example.hibernate_test.entitty.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2
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

            Employee emp = new Employee("Oleg", "Sidorov", "HR", 666);

            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)

            session.save(emp);//Заинсертили объект в базу и закрываем сессию(делаем коммит)
//            session.getTransaction().commit();//закрываем сессию(делаем коммит)

            /**
             * Получаем работника из БД
             */
            int myId = emp.getId();
//            session = factory.getCurrentSession();//Снова открываем сессию, так как закрывали ее(делали коммит)
//            session.beginTransaction();//Все время используем транзакции(даже когда делаем select)
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();//закрываем сессию(делаем коммит)
            System.out.println(employee);

            /**
             * Можем совместить две транзакции(добавление работника и получение его)
             * Нужно просто закомментировать некоторые моменты(первый коммит, получение сессии второй раз и начало транзакции)
             */

            System.out.println("Done!");

        }
        finally
        {
            factory.close();
        }
    }
}
