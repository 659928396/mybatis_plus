package com.example.mybatisplus02.service.impl;

import com.example.mybatisplus02.domain.entity.qdsbase.CommonPost;
import com.example.mybatisplus02.mapper.qdsbase.CommonPostMapper;
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
public class CommonPostServiceImpl extends ServiceImpl<CommonPostMapper, CommonPost> implements CommonPostService {

}
