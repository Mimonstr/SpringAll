package org.example.hibernate_test.entitty;

import javax.persistence.*;

@Entity//данный класс будет иметь отображение в БД
@Table(name = "employees")//к какой именно таблице привязываем класс
public class Employee
{
    //Связываем каждое поле со столбцом из таблицы:

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Описывает стратегию по генерации значений для столбца PK
    //GenerationType.IDENTITY полагается на автоматическое увеличение столбца по правилам, прописанным в БД
    //Когда не указывали стратегию использовалась GenerationType.AUTO(дефолтный тип).
    //Выбор стратегии будет зависеть от типа бд, с которой мы работаем.
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;

    public Employee()
    {
    }

    public Employee(String name, String surname, String department, int salary)
    {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
