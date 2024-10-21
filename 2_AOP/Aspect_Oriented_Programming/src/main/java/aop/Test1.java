package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary unilibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        unilibrary.addBook("Misha", book);
        unilibrary.addMagazine();


//        unilibrary.getBook();
//        unilibrary.getMagazine();
//        unilibrary.returnMagazine();
//        unilibrary.addBook();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();
        //Вызвались оба метода с pointcut: "execution(public void getBook())"

        //Хотим чтобы вызывался только для конкретного класса:
        //pointcut: "execution(public void aop.UniLibrary.getBook())"
        //Нужно прописать полное имя класса

        //А теперь хотим, чтобы работал со всеми геттерами(get*)
        //pointcut: "execution(public void get*())"

        //Если нам не важен тип возвращаемого значения
        //pointcut:"execution(public * returnBook())"

        //Для любого метода без параметров:
        //pointcut: "execution(* *())"

        /**
         * Pointcut с параметрами:
         */
        //pointcut: "execution(public void getBook(String))"

        //С любым одним параметром:
        //pointcut: "execution(public void getBook(*))"

        //Любое название метода с одним любым параметром:
        //pointcut: "execution(public void *(*))"

        //С любым количеством любых параметров:
        //pointcut: "execution(public void getBook(..))"

        //Хотим принимать класс:
        //pointcut: "execution(public void getBook(aop.Book))"



        context.close();
    }
}
