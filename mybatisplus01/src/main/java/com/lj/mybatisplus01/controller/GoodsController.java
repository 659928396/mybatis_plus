package com.lj.mybatisplus01.controller;


import com.lj.mybatisplus01.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangjie
 * @since 2020-09-30
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping("/findAll")
    public Object findAll(){
        return goodsMapper.selectList(null);
    }

}

