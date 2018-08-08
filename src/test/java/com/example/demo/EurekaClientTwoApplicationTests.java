package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.consumer.dto.ExcelDto;
import com.example.demo.consumer.util.ExcelUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/*@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore*/
public class EurekaClientTwoApplicationTests {
    @Test
    public void exce() {
        excelimport();
    }


	public static void excelimport() {

        int count = 15;
        JSONArray ja = new JSONArray();
        for (int i = 0; i < count; i++) {
            ExcelDto excelDto = new ExcelDto();
            excelDto.setName("POI" + i);
            excelDto.setAge(i);
            excelDto.setBirthday(new Date());
            excelDto.setHeight(i);
            excelDto.setWeight(i);
            excelDto.setSex(i / 2 == 0 ? false : true);
            ja.add(excelDto);
        }
        Map<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("name", "姓名1");
        headMap.put("age", "年龄");
        headMap.put("birthday", "生日");
        headMap.put("height", "身高");
        headMap.put("weight", "体重");
        headMap.put("sex", "性别");

        String title = "测试";
        /*  OutputStream outXls = new FileOutputStream("E://a.xls");
          System.out.println("正在导出xls...."); Date d = new Date();daochu excelbiaoge duitjicgabngzhanguiijeitamen bucuo an
          ExcelUtil.exportExcel(title,headMap,ja,null, 0, outXls);
          System.out.println("共"+count+"条数据,执行"+(new Date().getTime()-d.getTime())+"ms"); outXls.close();
        outXls.close();*/

        OutputStream outXlsx = null;
        try {
            outXlsx = new FileOutputStream("E://b.xlsx");
            System.out.println("正在导出xlsx....");
            Date d2 = new Date();
            ExcelUtil.exportExcel(title, headMap, ja, null, 0, outXlsx);
            System.out.println("共" + count + "条数据,执行" + (new Date().getTime() - d2.getTime()) + "ms");
            outXlsx.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
