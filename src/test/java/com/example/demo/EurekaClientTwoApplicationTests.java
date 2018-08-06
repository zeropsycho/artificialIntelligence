package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.consumer.entity.User;
import com.example.demo.consumer.util.ExcelUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class EurekaClientTwoApplicationTests {

	@Test
	public void contextLoads() {
        ExcelUtil excelUtil = new ExcelUtil();

        int count = 15;

        String title = "测试";
        // 数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("", "");
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(Long.valueOf("i" + i));
            user.setUserName("yum" + i);
            user.setPassWord("pass" + i);
            user.setBirthday(new Date());
            jsonArray.add(user);
        }
        // 列头
        Map<String, String> map = new HashMap<>();
        map.put("userName", "姓名");
        map.put("age", "年龄");
        map.put("sex", "性别");
        map.put("birthday", "生日");

        OutputStream outXlsx = null;
        try {
            outXlsx = new FileOutputStream("E://b.xlsx");
            System.out.println("正在导出xlsx....");
            Date d2 = new Date();
            excelUtil.exportExcel(title, map, jsonArray, null, 0, outXlsx);
            System.out.println("共" + count + "条数据,执行" + (new Date().getTime() - d2.getTime()) + "ms");
            outXlsx.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
