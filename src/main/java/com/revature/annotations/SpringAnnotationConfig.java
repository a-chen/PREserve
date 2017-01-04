package com.revature.annotations;

        import com.revature.data.*;
        import com.revature.data.dao.*;
        import com.revature.data.impl.*;
        import com.revature.middle.Delegate;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.revature"})
public class SpringAnnotationConfig {

    @Bean
    public CustomerDAO customerDAO() {return new CustomerDAOImpl();}
    @Bean
    public ItemDAO itemDAO() {return new ItemDAOImpl();}
    @Bean
    public OrderDAO orderDAO() {return new OrderDAOImpl();}
    @Bean
    public Order_ItemDAO order_itemDAO() {return new Order_ItemDAOImpl();}
    @Bean
    public ReservationDAO reservationDAO() {return new ReservationDAOImpl();}
    @Bean
    public TableDAO tableDAO() {return new TableDAOImpl();}

    @Bean
    public DataFacadeImpl facade() {
        return new DataFacadeImpl(  customerDAO(), itemDAO(),
                                    orderDAO(), order_itemDAO(),
                                    reservationDAO(), tableDAO());
    }

    @Bean
    public Delegate businessDelegate() {return new Delegate();}


}