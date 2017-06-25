package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongcj on 2017/6/19.
 */
@Service
public class GirlService {
    @Autowired
    public GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //返回你可能在上小学吧
            throw new GirlException(ResultEnum.PRIVATE_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回你可能在上初中吧
            throw new GirlException(ResultEnum.PRIVATE_SCHOOL.MIDDLE_SCHOOL);
        }
    }
}
