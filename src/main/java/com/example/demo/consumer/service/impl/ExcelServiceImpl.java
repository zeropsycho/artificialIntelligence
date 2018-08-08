package com.example.demo.consumer.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.consumer.dto.ExcelDto;
import com.example.demo.consumer.service.ExcelService;
import com.example.demo.consumer.util.ExcelUtil;
import org.springframework.stereotype.Service;
import share.constant.ExcelConfig;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZERO
 * @version V1.0
 * @description
 * @package com.example.demo.consumer.service.impl
 * @date 2018 08-07 9:57
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public void excelExport(HttpServletResponse response) {
        String title = ExcelConfig.TITLE;
        int count = 1;
        // 列表数据
        JSONArray ja = new JSONArray();
        for (int i = 0; i < count; i++) {
            ExcelDto s = new ExcelDto();
            s.setName("POIPOIPOIPOIPOIPOIPOIPOIPOIPOIPOIPOIPOIPOIPOIPOI" + i);
            s.setAge(i);
            s.setBirthday(new Date());
            s.setHeight(i);
            s.setWeight(i);
            s.setSex(i / 2 == 0 ? false : true);
            ja.add(s);
        }

        // 列头数据
        Map<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("name", "姓名");
        headMap.put("age", "年龄");
        headMap.put("birthday", "生日");
        headMap.put("height", "身高");
        headMap.put("weight", "体重");
        headMap.put("sex", "性别");
        try {
            // web导出
            // 创建一个Byte输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            OutputStream outputStream = response.getOutputStream();
            // 调用导出方法
            ExcelUtil.exportExcel(title, headMap, ja, null, 0, byteArrayOutputStream);
            // 创建一个Byte的输入流将输出流的Byte数组储存起来
            byte[] context = byteArrayOutputStream.toByteArray();
            InputStream inputStream = new ByteArrayInputStream(context);
            // 设置response参数,打开下载页面（1.contextType；2.输出格式文件名、编码格式；3.contentlength）
            response.reset();
            response.setContentLength(context.length);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String((title + ".xls").getBytes(), "iso-8859-1"));
            // 创建ServletOutputStream对象
            ServletOutputStream servletOutputStream = response.getOutputStream();
            // 创建BufferInputStream的对象
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            // 创建BufferOutputStream的对象
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(servletOutputStream);
            // 创建一个存储流的字节数组，初始化为8192个字节
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bufferedInputStream.read(buff, 0, buff.length))) {
                bufferedOutputStream.write(buff, 0, bytesRead);
            }
            // 关闭各项流
            bufferedOutputStream.close();
            bufferedInputStream.close();
            servletOutputStream.close();
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
