package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3
{
    public static void main(String[] args)
    {
//        Pet pet = new Cat();
//        Person person = new Person(pet);//hard coded зависимость
//        person.callYourPet();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Pet pet = context.getBean("myPet", Pet.class);//IoC
        //Person person = new Person(pet);//Тут происходит добавление зависимости(DI)
        //person.callYourPet();

        System.out.println("--------------------------------------------------");
        //Больше бинов не создает
        //Dependency injection with Constructor(<constructor-arg ref="myPet"/>)
        //Person person1 = context.getBean("myPerson", Person.class);
        //person1.callYourPet();
        //Больше объект Pet не нужен


        //Dependency injection with Setter(<property name="pet" ref="myPet"/>)
        Person person2 = context.getBean("myPerson", Person.class);
        person2.callYourPet();

        System.out.println("--------------------------------------------------");
        //Внедрение строк и других значений
        Person myPerson = context.getBean("myPerson", Person.class);
        System.out.println("Surname: " + myPerson.getSurname());
        System.out.println("My age: " + myPerson.getAge());


        System.out.println("--------------------------------------------------");
        //Внедрение строк и других значений из properties файла
        //Создание файла myApp.properties
        //Добавление его в наш applicationContext: <context:property-placeholder location="classpath:myApp.properties"/>

        context.close();
    }
}
