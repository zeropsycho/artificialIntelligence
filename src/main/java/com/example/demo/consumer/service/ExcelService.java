package com.example.demo.consumer.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ZERO
 * @version V1.0
 * @description 表格导出处理
 * @package com.example.demo.consumer.service
 * @date 2018 08-06 22:07
 */
public interface ExcelService {

    void excelImport(HttpServletResponse response);
}
