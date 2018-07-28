package com.example.demo.consumer.dao;

import com.example.demo.consumer.entity.PageEntity;
import com.example.demo.consumer.entity.PersonInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WenHui Li
 * @version V1.0
 * @date 2018 07-18 15:08
 */
@Mapper
public interface PersonInformationDao {

    /**
     * 对人员进行操作
     * @param personInformation 个人信息参数
     * @return int
     */
    int saveUserFinl(PersonInformation personInformation);

    List<PersonInformation> selectPersonList(PageEntity pageEntity);
}
