package org.example.hibernate_one_to_many_uni;




import org.example.hibernate_one_to_many_uni.entity.Department;
import org.example.hibernate_one_to_many_uni.entity.Employee;
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();//знает как должны создаваться сессии

        Session session = null;
        try
        {
//            session = factory.getCurrentSession();//Подключение к базе
//
//            Department dep = new Department("HR", 500, 1500);
//            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");




//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Department department = session.get(Department.class, 3);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");






//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Employee employee = session.get(Employee.class, 3);
//            System.out.println(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");




//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Department department = session.get(Department.class, 2);
//            session.delete(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");





//            session = factory.getCurrentSession();//Подключение к базе
//
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Misha", "Petrov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            session = factory.getCurrentSession();//Подключение к базе
            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)

            Employee employee1 = session.get(Employee.class, 5);
            Employee employee2 = session.get(Employee.class, 6);
            session.delete(employee1);
            session.delete(employee2);

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
