package com.imooc.handle;

import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ReusltUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hongcj on 2017/6/25.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static  Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ReusltUtil.error(girlException.getCode(),e.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ReusltUtil.error(-1,"未知错误");
        }
    }
}
