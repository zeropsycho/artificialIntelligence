package com.example.demo.consumer.service;

import com.example.demo.consumer.entity.PageEntity;
import com.example.demo.consumer.entity.PersonInformation;
import share.exception.ReturnFormat;

/**
 * @author Administrator
 * @version V1.0
 * @Title: PersonInformationService.java
 * @Package com.example.demo.consumer.service
 * @date 2018 07-18 15:19.
 */
public interface PersonInformationService {

    /**
     * 查询用户详情
     * @param pageEntity
     * @return
     */
    ReturnFormat selectPersonList(PageEntity pageEntity);

    /**
     * 批量录入人员
     * @param personInformations
     * @return
     */
    ReturnFormat saveUserFinl(PersonInformation personInformations);
}
