package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //Бин создается даже если мы его не запрашивали(scope = singleton)
        //Является дефолтным
//        Dog myDog = context.getBean("myPet", Dog.class);
//        Dog yourDog = context.getBean("myPet", Dog.class);
        //Является общим для всех!!! Создается всего 1 бин
//        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog == yourDog));
//        System.out.println(myDog);
//        System.out.println(yourDog);

//        myDog.setName("Belka");
//        yourDog.setName("Strelka");
//        System.out.println(myDog.getName());
//        System.out.println(yourDog.getName());


        System.out.println("--------------------------------------------------");
        //Prototype - создается только после обращения к спринг контейнеру с помощью метода getBean
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        myDog.setName("Belka");
        yourDog.setName("Strelka");
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());


        context.close();
    }
}
