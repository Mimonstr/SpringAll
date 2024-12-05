package com.paryshkin.spring.rest.configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses()// <param-value>/WEB-INF/applicationContext.xml</param-value>
    {
        return new Class[]{MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() // <url-pattern>/</url-pattern>
    {
        return new String[]{"/"};
    }
}
