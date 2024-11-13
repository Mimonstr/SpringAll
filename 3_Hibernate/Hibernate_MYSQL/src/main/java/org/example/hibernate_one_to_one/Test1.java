package org.example.hibernate_one_to_one;


import org.example.hibernate_one_to_one.entity.Detail;
import org.example.hibernate_one_to_one.entity.Employee;
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
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();//знает как должны создаваться сессии

        Session session = null;
        try
        {
//            Session session = factory.getCurrentSession();//Подключение к базе
//            Employee employee = new Employee("Misha", "Petrov", "IT", 500);
//            Detail detail = new Detail("Moscow", "12345678", "petrov@mail.ru");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            session.save(employee);//детали сохранятся сами
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            Session session = factory.getCurrentSession();//Подключение к базе
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Baku", "987654321", "olejka@gmail.com");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            session.save(employee);//детали сохранятся сами
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            /**
             * Получаем работника из БД
             */

//            session = factory.getCurrentSession();//Подключение к базе
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Employee emp = session.get(Employee.class, 10);
//            //Выбрасывается исключение: Connection leak detected: there are 1 unclosed connections
//            //Лучше закрывать сессию в блоке finally, так как сейчас до коммита мы не дошли
//            System.out.println(emp.getEmpDetail());//Благодаря каскаду можем получить и детали
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            /**
             * Удаляем объект из БД(вместе с ним удалятся и его детали)
             */

            session = factory.getCurrentSession();//Подключение к базе

            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);


            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
