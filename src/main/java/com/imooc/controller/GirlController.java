package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ReusltUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 对girl进行操作
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRespository;

    @Autowired
    private GirlService girlService;

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    /**
     * 获取所有的girl
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girls(){
        logger.info("1111");
        return girlRespository.findAll();
    }

    /**
     * 根据ID获取girl的信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirlsById(@PathVariable("id") Integer id){
        return girlRespository.findOne(id);
    }


    /**
     * 根据年龄获取girl集合
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getGirlListByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    /**
     * 修改girl
     * @return
     */
    @PutMapping(value = "/girls")
    public Girl updateGirl(@Valid Girl girl){
//        Girl girl = new Girl();
//        girl.setId(id);
//        girl.setAge(age);
//        girl.setCupSize(cupSize);
        return  girlRespository.save(girl);
    }

    /**
     * 添加girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()){
//            bindingResult.getFieldError().getDefaultMessage()为表单校验返回的错误信息
            return ReusltUtil.error(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ReusltUtil.success(girlRespository.save(girl));
    }

//    /**
//     * 删除girl
//     * @param id
//     */
//    @DeleteMapping(value = "/girls")
//    public void delGirl(@RequestParam(value = "id", required = true) Integer id){
//        girlResposity.delete(id);
//    }

    /**
     * 删除girl
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void delGirl(@PathVariable(value = "id", required = true) Integer id){
        girlRespository.delete(id);
    }

    @Transactional
    //测试事务
    @GetMapping(value = "/insertTowGirl")
    public void insertTwo(){

        Girl girl2 = new Girl();
        girl2.setCupSize("A");
        girl2.setAge(18);
        girlRespository.save(girl2);

        Girl girl = new Girl();
        girl.setCupSize("EE");
        girl.setAge(17);
        girlRespository.save(girl);
    }

    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
