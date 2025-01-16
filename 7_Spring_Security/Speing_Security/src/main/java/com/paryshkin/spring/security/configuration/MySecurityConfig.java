package com.paryshkin.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.paryshkin.spring.security")
public class MySecurityConfig
{

    @Autowired
    DataSource dataSource;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    // Настройка JDBC аутентификации с простыми паролями
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//
//        authenticationManagerBuilder
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());  // Используем NoOpPasswordEncoder для простоты
//
//        return authenticationManagerBuilder.build();
//    }

    //Если используем имена таблиц users и authorities с соответствующими полями, то запросы делать не нужно
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource);

        return authenticationManagerBuilder.build();
    }

    // Добавляем бин для AuthenticationManager с JDBC аутентификацией

//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception
//    {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
//                .passwordEncoder(passwordEncoder()) // Используем BCrypt для паролей
//                .and()
//                .build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder(); // Для безопасного хранения паролей
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/hr_info").hasRole("HR")
                        .requestMatchers("/manager_info").hasRole("MANAGER")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/", true) // Перенаправление на "/" после входа
                        //.loginPage("/login")//Если хотим свою страницу
                        .permitAll()

                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("misha")
//                .password("misha")
//                .roles("EMPLOYEE")
//                .build());
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("elena")
//                .password("elena")
//                .roles("HR")
//                .build());
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("ivan")
//                .password("ivan")
//                .roles("MANAGER", "HR")
//                .build());
//
//        return manager;
//    }


    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector()
    {
        return new HandlerMappingIntrospector();
    }
}
