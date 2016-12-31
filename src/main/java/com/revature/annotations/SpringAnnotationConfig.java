package com.revature.annotations;

        import com.revature.data.CustomerDAO;
        import com.revature.data.CustomerDAOImpl;
        import com.revature.data.DataFacadeImpl;
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
    public DataFacadeImpl dataFacade(){
        return new DataFacadeImpl();
    }

    @Bean
    public DataFacadeImpl dataFacade(CustomerDAO customerDAO ){
        return new DataFacadeImpl( customerDAO() ); // constructor injection
    }
}
