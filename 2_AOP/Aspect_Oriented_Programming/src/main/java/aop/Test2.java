package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudents();
        try
        {
            List<Student> students = university.getStudents();
            //Результат запишется в students только после выполнения AfterReturning эдвайса.
            //То есть, если наш эдвайс, меняет возвращаемое значение, то и в переменную students придут обновленные данные
            System.out.println(students);
        }
        catch (Exception e)
        {
            System.out.println("Было поймано исключение " + e);
        }


        context.close();

    }
}
