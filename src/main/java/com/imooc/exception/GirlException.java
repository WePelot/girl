package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by hongcj on 2017/6/25.
 */
public class GirlException extends RuntimeException {
    //为什么要继承RuntimeException,因为Spring框架里只会对RuntimeException的异常进行事务回滚
    public Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
