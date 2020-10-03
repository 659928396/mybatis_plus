package com.lj.mybatisplus01.service.impl;

import com.lj.mybatisplus01.entity.TestMybatisPlusUser;
import com.lj.mybatisplus01.mapper.TestMybatisPlusUserMapper;
import com.lj.mybatisplus01.service.TestMybatisPlusUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangjie
 * @since 2020-10-02
 */
@Service
public class TestMybatisPlusUserServiceImpl extends ServiceImpl<TestMybatisPlusUserMapper, TestMybatisPlusUser> implements TestMybatisPlusUserService {

}
