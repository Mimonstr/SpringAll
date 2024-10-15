package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope("prototype")
public class Dog implements Pet
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

//    @PostConstruct
    protected void init()
    {
        System.out.println("Class Dog: init method");
    }
//    @PreDestroy
    private void destroy()
    {
        System.out.println("Class Dog: destroy method");
    }

    public Dog()
    {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say()
    {
        System.out.println("Bow-Wow");
    }
}
