package com.lj.mybatisplus01.service.impl;

import com.lj.mybatisplus01.entity.Goods;
import com.lj.mybatisplus01.mapper.GoodsMapper;
import com.lj.mybatisplus01.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangjie
 * @since 2020-09-30
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}
