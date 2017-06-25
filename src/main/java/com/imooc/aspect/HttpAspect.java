package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.util.Objects;

/**
 * Created by hongcj on 2017/6/23.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //定义一个切面
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
   public void log(){

   }

   @Before("log()")
   public void before(JoinPoint joinPoint){
       logger.info("进入GirlController类的方法之前");
       //获取request
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       //url
       StringBuffer requestURL = request.getRequestURL();
       logger.info("url={}",requestURL);
       //methord
       String method = request.getMethod();
       logger.info("method={}",method);
       //ip
       String ip = request.getRemoteAddr();
       logger.info("ip={}",ip);
       //类方法
       String className = joinPoint.getSignature().getDeclaringTypeName();  //类名
       String name = joinPoint.getSignature().getName();  //类方法
       logger.info("class_method={}",className + "."  + name);
       //类参数
       Object[] args = joinPoint.getArgs();
       logger.info("args={}",args);
   }

   @After("log()")
   public void logAfter(){
       logger.info("进入GirlController类的方法之后");
   }

   @AfterReturning(returning = "object",pointcut = "log()")
   public void afterRuturning(Object object){
        if(object !=  null){
            logger.info("response={}",object.toString());
        }
   }
}
