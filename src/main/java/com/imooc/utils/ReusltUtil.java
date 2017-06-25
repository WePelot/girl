package com.imooc.utils;

import com.imooc.domain.Result;

/**
 * Created by hongcj on 2017/6/25.
 */
public class ReusltUtil {
    public static Result success(Object object){
        Result result = new Result();
        //0代表成功
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
