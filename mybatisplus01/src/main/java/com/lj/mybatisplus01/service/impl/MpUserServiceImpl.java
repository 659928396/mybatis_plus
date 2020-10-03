package com.lj.mybatisplus01.service.impl;

import com.lj.mybatisplus01.entity.MpUser;
import com.lj.mybatisplus01.mapper.MpUserMapper;
import com.lj.mybatisplus01.service.MpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangjie
 * @since 2020-10-03
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements MpUserService {

}
