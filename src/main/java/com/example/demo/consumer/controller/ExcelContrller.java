package com.example.demo.consumer.controller;

import com.example.demo.consumer.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import share.constant.RequestHeader;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ZERO
 * @version V1.0
 * @description
 * @package com.example.demo.consumer.controller
 * @date 2018 08-07 10:46
 */
@RestController
@RequestMapping(value = RequestHeader.REQUEST_HEADER_EXCEL)
public class ExcelContrller {

    @Autowired
    private ExcelService excelService;

    @GetMapping(value = "/export")
    public void exportExcel(HttpServletResponse response) {
        excelService.excelExport(response);
    }

    @GetMapping(value = "/test")
    public String getTest() {
        return "sucess";
    }
}
