package com.revature.data;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.revature.annotations.SpringAnnotationConfig;

public class Order_ItemDAOImplTest {
	
    @Test
    public void getAllOrder_Items() throws Exception {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllOrder_Items());
        context.registerShutdownHook();
    }
	
	@Test
	public void getOrder_ItemByOrderId() {
	    AbstractApplicationContext context =
	            new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
	
	    DataFacade facade = context.getBean("facade", DataFacade.class);
	    System.out.println(facade.getOrder_ItemByOrderId(1));
	    context.registerShutdownHook();
	}

	
}
