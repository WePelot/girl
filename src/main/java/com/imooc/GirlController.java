package com.imooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对girl进行操作
 */
@RestController
public class GirlController {

    @Autowired
    private GirlResposity girlResposity;

    /**
     * 获取所有的girl
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girls(){
        return girlResposity.findAll();
    }

    /**
     * 根据ID获取girl的信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirlsById(@PathVariable("id") Integer id){
        return girlResposity.findOne(id);
    }


    /**
     * 根据年龄获取girl集合
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getGirlListByAge(@PathVariable("age") Integer age){
        return girlResposity.findByAge(age);
    }

    /**
     * 修改girl
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls")
    public Girl updateGirl(@RequestParam(value = "id",required = true) Integer id,
                           @RequestParam(value = "age",required = false,defaultValue = "0") Integer age,
                           @RequestParam(value = "cupSize",required = false,defaultValue = "A") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return  girlResposity.save(girl);
    }

    /**
     * 添加girl
     * @param age
     * @param cupSize
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam(value = "age",required = false,defaultValue = "0") Integer age,
                        @RequestParam(value = "cupSize", required = false, defaultValue = "A") String cupSize){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlResposity.save(girl);
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
        girlResposity.delete(id);
    }

    @Transactional
    //测试事务
    @GetMapping(value = "/insertTowGirl")
    public void insertTwo(){

        Girl girl2 = new Girl();
        girl2.setCupSize("A");
        girl2.setAge(18);
        girlResposity.save(girl2);

        Girl girl = new Girl();
        girl.setCupSize("EE");
        girl.setAge(17);
        girlResposity.save(girl);


    }
}
