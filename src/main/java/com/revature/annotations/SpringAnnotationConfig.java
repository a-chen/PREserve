package com.revature.annotations;

        import com.revature.data.CustomerDAO;
        import com.revature.data.CustomerDAOImpl;
        import com.revature.data.FacadeImpl;
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
    public FacadeImpl facade(){
        return new FacadeImpl();
    }

    @Bean
    public FacadeImpl facade(CustomerDAO customerDAO ){
        return new FacadeImpl( customerDAO() ); // constructor injection
    }
}
