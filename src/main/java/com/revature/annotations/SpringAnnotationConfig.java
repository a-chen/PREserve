package com.revature.annotations;

        import com.revature.beans.Customer;
        import com.revature.spring.CustomerDAO;
        import com.revature.spring.CustomerDAOImpl;
        import com.revature.spring.Facade;
        import org.springframework.beans.factory.annotation.Autowire;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

/**
 * Created by bcant on 12/29/2016.
 */
@Configuration
public class SpringAnnotationConfig {

    @Bean
    public CustomerDAO customerDAO(){
        return new CustomerDAOImpl();
    }

    @Bean(name="facade")
    public Facade facade(){
        return new Facade();
    }

    @Bean
    public Facade facade( CustomerDAO customerDAO ){
        return new Facade( customerDAO() ); // constructor injection
    }
}
