package org.example.hibernate_one_to_one.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //cascade = CascadeType.ALL: выполнение операции не только на Entity, на котором вызывается, но и на связанных с ним Entity.
    //То есть, если увольняют работника, зачем нам держать о нем данные(Details)
    @OneToOne(cascade = CascadeType.ALL)//Отношение один к одному
    @JoinColumn(name = "details_id")//связываем таблицы
    private Detail empDetail;

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

    public Detail getEmpDetail()
    {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail)
    {
        this.empDetail = empDetail;
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
