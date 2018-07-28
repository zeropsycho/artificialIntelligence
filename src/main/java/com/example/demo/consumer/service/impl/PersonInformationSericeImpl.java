package com.example.demo.consumer.service.impl;

import com.example.demo.consumer.dao.PersonInformationDao;
import com.example.demo.consumer.entity.PageEntity;
import com.example.demo.consumer.entity.PersonInformation;
import com.example.demo.consumer.service.PersonInformationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import share.enums.StatusCode;
import share.exception.ReturnFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZERO
 * @version V1.0
 * @deprecated 用户个人信息
 * @package com.example.demo.consumer.service.impl
 * @date 2018 07-18 15:25
 */
@Service
public class PersonInformationSericeImpl implements PersonInformationService {

    @Autowired
    private PersonInformationDao personInformationDao;

    /**
     * 查询用户信息
     * @param pageEntity
     * @return
     */
    @Override
    public ReturnFormat selectPersonList(PageEntity pageEntity) {
        ReturnFormat returnFormat = new ReturnFormat();
        if (null == pageEntity.getPageNum() || null == pageEntity.getPageSize()) {
            return new ReturnFormat(StatusCode.QUERY_FAILURE.getCode(), StatusCode.QUERY_FAILURE.getMessage(), "参数不能为空", null);
        }
        PageHelper.startPage(pageEntity.getPageNum(), pageEntity.getPageSize());
        List<PersonInformation> personInformationList = personInformationDao.selectPersonList(pageEntity);

        PageInfo<PersonInformation> pageInfo = new PageInfo<PersonInformation>(personInformationList);
        System.err.println(">>>>>>当前页：<<<<<<" + pageInfo.getPageNum());
        System.err.println(">>>>>>每页数量：<<<<<<" + pageInfo.getPageSize());
        System.err.println(">>>>>>当前页的数量：<<<<<<" + pageInfo.getSize());
        System.err.println(">>>>>>页面第一个元素在数据库中的行号：<<<<<<" + pageInfo.getStartRow());
        System.err.println(">>>>>>当前页面最后一个元素在数据库中的行号：<<<<<<" + pageInfo.getEndRow());
        System.err.println(">>>>>>总页数：<<<<<<" + pageInfo.getPages());
        System.err.println(">>>>>>上一页：<<<<<<" + pageInfo.getPrePage());
        System.err.println(">>>>>>下一页：<<<<<<" + pageInfo.getNextPage());
        System.err.println(">>>>>>导航页码数：<<<<<<" + pageInfo.getNavigatePages());
        System.err.println(">>>>>>所有导航页号：<<<<<<" + pageInfo.getNavigatepageNums());
        System.err.println(">>>>>>导航条上的第一页：<<<<<<" + pageInfo.getNavigateFirstPage());
        System.err.println(">>>>>>导航条上的最后一页：<<<<<<" + pageInfo.getNavigateLastPage());

        System.err.println(">>>>>>>>>>" + pageInfo.toString());
        returnFormat = new ReturnFormat(StatusCode.QUERY_FAILURE.getCode(), StatusCode.QUERY_FAILURE.getMessage(), null, pageInfo);
        return returnFormat;
    }

    /**
     * 录入人员信息
     * @param personInformations
     * @return
     */
    @Override
    public ReturnFormat saveUserFinl(PersonInformation personInformations) {
        if (null == personInformations) {
            return new ReturnFormat(StatusCode.ADD_SUCCESS.getCode(), StatusCode.ADD_SUCCESS.getMessage());
        }

        // 获取人员信息存储List，统一录入数据库
        List<PersonInformation> personInformationsList = new ArrayList<>();
        return null;
    }
}
