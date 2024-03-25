package org.frank.spring.boot.time.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class DateTimeController {

    @GetMapping("/time")
    public String getCurrentTime() {
        ZonedDateTime now = ZonedDateTime.now(); // 默认使用系统时区
        return now.toString(); // 返回包含时区信息的日期时间字符串
    }
}
