package com.atguigu.jdbc.whc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SelectAll {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/select")
    public Map<String,Object> select(){
        List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from department");

        return list.get(0);
    }
}
