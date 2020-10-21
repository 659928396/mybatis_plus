package com.example.mybatisplus02.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.mybatisplus02.domain.entity.CommonPost;
import com.example.mybatisplus02.mapper.CommonPostMapper;
import com.example.mybatisplus02.service.CommonPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通用贴吧管理 服务实现类
 * </p>
 *
 * @author liangjie
 * @since 2020-10-21
 */
@Service
@DS("mybatis_plus02")
public class CommonPostServiceImpl extends ServiceImpl<CommonPostMapper, CommonPost> implements CommonPostService {

}
