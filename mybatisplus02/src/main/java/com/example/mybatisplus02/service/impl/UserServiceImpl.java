package com.example.mybatisplus02.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.mybatisplus02.domain.entity.User;
import com.example.mybatisplus02.mapper.UserMapper;
import com.example.mybatisplus02.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangjie
 * @since 2020-10-21
 */
@Service
@DS("mybatis_plus")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
