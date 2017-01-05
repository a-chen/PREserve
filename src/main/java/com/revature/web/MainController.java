package com.revature.web;

import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private Delegate businessDelegate;
    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value={"/home"}, method= RequestMethod.GET)
    // no response body.. returned value goes to IRVR
    public String homePage(){
        // InternalResourceViewResolver will prepend the prefix
        // /WEB-INF/pages/index.html
        // requestDispatcher.forward(req,resp)
        return "template";
    }

    @RequestMapping(value={"/index"}, method=RequestMethod.GET)
    public String indexPage(){
        return "index";
    }


}
