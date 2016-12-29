package com.revature.annotations;

        import com.revature.data.CustomerDAO;
        import com.revature.data.CustomerDAOImpl;
        import com.revature.data.Facade;
        import org.springframework.beans.factory.annotation.Autowire;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

/**
 * Created by bcant on 12/29/2016.
 */
@Configuration
public class SpringAnnotationConfig {

    @Bean(name = "customerName")
    public CustomerDAO customerDAO(){
        return new CustomerDAOImpl();
    }

    @Bean(name="facade"/*, initMethod = "initialize", destroyMethod = "cleanup", autowire = Autowire.BY_NAME*/)
    public Facade facade(){
        return new Facade();
    }
/*
    @Bean(name="facade", initMethod="initialize", destroyMethod="cleanup")
    public Facade facade(){
		*//* Setter injection
		 * Facade f = new Facade(); f.setDao( dao() ); return f;*//*
        return new Facade( dao()); // constructor injection
    }*/
}
