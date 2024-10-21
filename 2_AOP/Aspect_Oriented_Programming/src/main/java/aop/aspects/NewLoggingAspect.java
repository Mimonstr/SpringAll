package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect
{
    @Around("execution(public String returnBook())")//Должны САМИ запустить target метод!!!
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {//Тип возвращаемого значения должен быть такой же, как у target метода, но чаще всего пишут Object!
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        /**
         * Cами обрабатывать исключения
         */
        Object targetMethodResult = null;
        //Можем сами обрабатывать исключения(не всегда хорошее решение,
        // так как никто не знает о том, что было выброшено исключение)
        //Так мы пытаемся скрыть проблему

//        try
//        {
//            targetMethodResult = proceedingJoinPoint.proceed();//сами вызываем таргет метод
//
//        }
//        catch (Exception e)
//        {
//            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
//            targetMethodResult = "Неизвестное название книги";
//        }

        /**
         * Пробрасываем исключения
         */
        //Но Лучше, мне кажется, пробросить исключение дальше!!!
        try
        {
            targetMethodResult = proceedingJoinPoint.proceed();//сами вызываем таргет метод

        }
        catch (Exception e)
        {
            System.out.println("aroundReturnBookLoggingAdvice: пробрасываем исключение " + e);
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        return targetMethodResult;
    }
}
