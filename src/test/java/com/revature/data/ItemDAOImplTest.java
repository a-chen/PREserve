package com.revature.data;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.revature.annotations.SpringAnnotationConfig;

public class ItemDAOImplTest {
	
    @Test
    public void getAllItems() throws Exception {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllItems());
        context.registerShutdownHook();
    }
	
	@Test
	public void getItemById() {
	    AbstractApplicationContext context =
	            new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
	
	    DataFacade facade = context.getBean("facade", DataFacade.class);
	    System.out.println(facade.getItemById(1));
	    context.registerShutdownHook();
	}
}
