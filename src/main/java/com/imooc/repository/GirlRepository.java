/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.imooc.repository;

import java.util.List;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据仓库获取
 * @author hongcj
 * @version V1.0
 * @since 2017-06-22 13:54
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    public List<Girl> findByAge(Integer age);
}
