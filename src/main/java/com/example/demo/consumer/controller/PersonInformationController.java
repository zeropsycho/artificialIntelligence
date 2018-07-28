package com.example.demo.consumer.controller;

import com.example.demo.consumer.entity.PageEntity;
import com.example.demo.consumer.service.PersonInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import share.constant.RequestHeader;
import share.exception.ReturnFormat;

/**
 * @author ZERO
 * @version V1.0
 * @description 人员信息
 * @package com.example.demo.consumer.controller
 * @date 2018 07-18 15:44
 */
@RestController
@RequestMapping(value = RequestHeader.REQUEST_HEADER_PERSON)
public class PersonInformationController {

    @Autowired
    private PersonInformationService personInformationService;

    /**
     * 查询人员
     * @param pageEntity
     * @return ReturnFormat
     */
    @PostMapping("/search/list")
    public ReturnFormat selectPersonList(PageEntity pageEntity) {
        return personInformationService.selectPersonList(pageEntity);
    }
}
