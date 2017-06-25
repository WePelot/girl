package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2017/6/18.
 */
@Controller
public class HelloHtmlController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/helloHtml",method = RequestMethod.GET)
    public String say(){
//        return "Hello Spring Boot";
        return "index";
    }
}
