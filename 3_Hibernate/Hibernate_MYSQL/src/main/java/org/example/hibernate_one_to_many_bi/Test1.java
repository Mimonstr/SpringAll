package org.example.hibernate_one_to_many_bi;



import org.example.hibernate_one_to_many_bi.entity.Department;
import org.example.hibernate_one_to_many_bi.entity.Employee;
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
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Misha", "Petrov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");




            session = factory.getCurrentSession();//Подключение к базе
            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгружаем работников");
            department.getEmps().get(0);

            session.getTransaction().commit();
            //перенесли после коммита:
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            System.out.println("Done!");






//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");




//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);
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


//            session = factory.getCurrentSession();//Подключение к базе
//            session.beginTransaction();//Открываем транзакцию... Должны делать сами(в sql открывается само, когда делаем insert)
//
//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
