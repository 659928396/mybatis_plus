package com.example.mybatisplus02.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus02.constant.ResultCode;
import com.example.mybatisplus02.domain.dto.SearchCondition;
import com.example.mybatisplus02.domain.entity.CommonPost;
import com.example.mybatisplus02.domain.vo.CommonPostVO;
import com.example.mybatisplus02.domain.vo.ResultVO;
import com.example.mybatisplus02.map.CommonPostVOMapper;
import com.example.mybatisplus02.service.CommonPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 通用贴吧管理 前端控制器
 * </p>
 *
 * @author liangjie
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/api/common-post")
@Api(value = "CommonPostController", tags = "通用贴吧管理接口类")
public class CommonPostController {

    @Autowired
    private CommonPostService commonPostService;
    /**
     * 根据第三方关联表ID查询
     * @param thirdTableId
     * @return
     */
    @GetMapping("/query/{thirdTableId}")
    @ApiOperation(value = "通用贴吧管理-查询接口", notes = "必传参数：thirdTableId", consumes = "application/json")
    public ResultVO queryById(@PathVariable Long thirdTableId) {
        ResultVO resultVO = new ResultVO();
        QueryWrapper<CommonPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("thirdTableId", thirdTableId);
        CommonPost commonPost = commonPostService.getOne(queryWrapper);
        CommonPostVO commonPostVO = CommonPostVOMapper.INSTANCE.toCommonPostVO(commonPost);
        resultVO.setData(commonPostVO);
        return resultVO;
    }

    /**
     * 根据第三方关联表ID删除
     * @param thirdTableId
     * @return
     */
    @DeleteMapping("/delete/{thirdTableId}")
    @ApiOperation(value = "通用贴吧管理-删除接口", notes = "必传参数：thirdTableId", consumes = "application/json")
    public ResultVO deleteById(@PathVariable Long thirdTableId) {
        ResultVO resultVO = new ResultVO();
        QueryWrapper<CommonPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("thirdTableId", thirdTableId);
        boolean flag = commonPostService.remove(queryWrapper);
        if (flag) {
            //删除成功，并清理缓存（因为该项目为基础服务，被调用后，会在业务系统上再组装成大对象，在业务系统上再加缓存即可，因此不在该项目上加缓存）
            Map<String, Object> map = new HashMap<>();
            map.put("gid",thirdTableId);
            resultVO.setData(map);
        } else {
            resultVO.setCode(ResultCode.UNKNOWN_API_ERROR);
            resultVO.setMessage(ResultCode.UNKNOWN_API_ERROR.msg());
        }
        return resultVO;
    }

    @PostMapping("/add")
    @ApiOperation(value = "通用贴吧管理-新增接口", notes = "必传参数：commonPostVO", consumes = "application/json")
    public ResultVO add(@RequestBody CommonPostVO commonPostVO) {
        ResultVO resultVO = new ResultVO();
        CommonPost commonPost = CommonPostVOMapper.INSTANCE.toCommonPost(commonPostVO);
        boolean flag = commonPostService.save(commonPost);
        if (flag) {
            Map<String, Object> map = new HashMap<>();
            map.put("gid",commonPost.getGid());
            resultVO.setData(map);
        } else {
            resultVO.setCode(ResultCode.UNKNOWN_API_ERROR);
            resultVO.setMessage(ResultCode.UNKNOWN_API_ERROR.msg());
        }
        return resultVO;
    }

    @PutMapping("/modify")
    @ApiOperation(value = "通用贴吧管理-修改接口", notes = "必传参数：commonPostVO", consumes = "application/json")
    public ResultVO modifyById(@RequestBody CommonPostVO commonPostVO) {
        ResultVO resultVO = new ResultVO();
        //1 根据thirdTableId查询
        QueryWrapper<CommonPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("thirdTableId", commonPostVO.getThirdTableId());
        CommonPost commonPost = commonPostService.getOne(queryWrapper);
        //2 赋值
        BeanUtils.copyProperties(commonPostVO, commonPost, "gid");

        boolean flag = commonPostService.updateById(commonPost);
        if (flag) {
            //更新成功
            Map<String, Object> map = new HashMap<>();
            map.put("gid",commonPost.getGid());
            resultVO.setData(map);
        } else {
            resultVO.setCode(ResultCode.UNKNOWN_API_ERROR);
            resultVO.setMessage(ResultCode.UNKNOWN_API_ERROR.msg());
        }
        return resultVO;
    }

    @PostMapping("/page")
    @ApiOperation(value = "通用贴吧管理-分页查询接口", notes = "必传参数：searchCondition", consumes = "application/json")
    public ResultVO queryPage(@RequestBody SearchCondition searchCondition) {
        ResultVO resultVO = new ResultVO();
        // Step1：创建一个 Page 对象
        //Page<MpUser> page = new Page<>();
        Page<CommonPost> page = new Page<>(searchCondition.getPageNo(), searchCondition.getPageSize());
        // Step2：调用 mybatis-plus 提供的分页查询方法
        QueryWrapper<CommonPost> queryWrapper = new QueryWrapper<>();
        if (!searchCondition.getParam().isEmpty()) {//添加查询条件，默认都是like
            Set<Map.Entry<String, Object>> entries = searchCondition.getParam().entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                Object value = entry.getValue();
                queryWrapper.like(key, value);
            }
        }
        //排序暂时不添加
        commonPostService.page(page, queryWrapper);//执行查询
        resultVO.setData(page);
        return resultVO;
    }
}

