package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person
{
    //Такое внедрение не рекомендуется
//    @Autowired
//    @Qualifier("dog")
    private Pet pet;

//    @Value("Parshin")
    @Value("${person.surname}")
    private String surname;
//    @Value("24")
    @Value("${person.age}")
    private int age;

    public Person()
    {
        System.out.println("Person bean is created");
    }

//    @Autowired
//    public Person(@Qualifier("dog") Pet pet)
//    {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }
    public Person(Pet pet)
    {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

//    @Autowired
//    @Qualifier("catBean")
    public void setPet(Pet pet)
    {
        System.out.println("Class Person: setPet");
        this.pet = pet;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        System.out.println("Class Person: setSurname");
        this.surname = surname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        System.out.println("Class Person: setAge");
        this.age = age;
    }

    public void callYourPet()
    {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
