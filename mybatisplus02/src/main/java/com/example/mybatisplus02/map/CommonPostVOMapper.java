package com.example.mybatisplus02.map;

import com.example.mybatisplus02.domain.entity.CommonPost;
import com.example.mybatisplus02.domain.vo.CommonPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: liangjie
 * @Date: 2020/10/14 14:57
 */
@Mapper(componentModel = "Spring")
public interface CommonPostVOMapper {

    CommonPostVOMapper INSTANCE = Mappers.getMapper(CommonPostVOMapper.class);

    /*@Mappings({
            @Mapping(target = "gid", source = "gid"),
            @Mapping(target = "skey", source = "svalue")
    })//某些字段名不一样的，可以手动添加映射
    */
    CommonPostVO toCommonPostVO(CommonPost commonPost);

    List<CommonPostVO> toCommonPostVOs(List<CommonPost> commonPosts);

    CommonPost toCommonPost(CommonPostVO commonPostVO);

}
