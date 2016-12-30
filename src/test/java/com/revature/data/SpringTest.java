package com.revature.data;

import com.revature.annotations.SpringAnnotationConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by bcant on 12/29/2016.
 */
public class SpringTest {
    @Test
    public void lifeCycle(){
        AbstractApplicationContext ctxt = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        ctxt.getBean("facade", FacadeImpl.class).getFullName();
        ctxt.registerShutdownHook();
    }
}
