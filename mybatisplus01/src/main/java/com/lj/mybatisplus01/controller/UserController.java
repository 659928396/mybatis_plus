package com.lj.mybatisplus01.controller;

import com.lj.mybatisplus01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public Object findAll(){
        return userMapper.selectList(null);
    }
}
