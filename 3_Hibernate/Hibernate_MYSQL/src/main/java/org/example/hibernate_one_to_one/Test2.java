package org.example.hibernate_one_to_one;


import org.example.hibernate_one_to_one.entity.Detail;
import org.example.hibernate_one_to_one.entity.Employee;
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
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();//знает как должны создаваться сессии

        Session session = null;
        try
        {
//            session = factory.getCurrentSession();//Подключение к базе
//            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
//            Detail detail = new Detail("New-York", "64188614123", "nikolay@mail.ru");
//
//            employee.setEmpDetail(detail);//Нужно было это добавить, чтобы не было равно null
//            detail.setEmployee(employee);
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            session.save(detail);//делаем наоборот, но ссылки у работника на детали не будет(она будет равна null)
//
//            session.getTransaction().commit();
//            System.out.println("Done!");




//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");




//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Detail detail = session.get(Detail.class, 4);
//            session.delete(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            //Так сделать нельзя, чтобы удалились только детали, так как
//            // В таблице employee details_id - foreign key и тогда ему не на что будет ссылаться
//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Detail detail = session.get(Detail.class, 1);
//            session.delete(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



            //Так сделать нельзя, чтобы удалились только детали, так как
            // В таблице employee details_id - foreign key и тогда ему не на что будет ссылаться
            //Поэтому сначала должны разорвать связь, а потом удалить детали
            session = factory.getCurrentSession();//Подключение к базе
            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)

            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);//разрываем связь, поэтому можем удалить детали
            session.delete(detail);

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
