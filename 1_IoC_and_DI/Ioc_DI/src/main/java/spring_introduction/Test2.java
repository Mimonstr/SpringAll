package spring_introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();
        //Чтобы у нас была кошка, нам нужно всего лишь изменить applicationContext с Dog на Cat
        //class="spring_introduction.Cat">

        context.close();
    }
}
