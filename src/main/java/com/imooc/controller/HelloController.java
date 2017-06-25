package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/6/18.
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String say(){
//        return "Hello Spring Boot";
        return girlProperties.getCupSize();
    }

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String sayId(@PathVariable("id") Integer id){
        return "传入的ID为:" + id;
    }

    @RequestMapping(value = "/helloDefault",method = RequestMethod.GET)
    public String sayIdDefault(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id){
        return "传入的ID为:" + id;
    }
}
