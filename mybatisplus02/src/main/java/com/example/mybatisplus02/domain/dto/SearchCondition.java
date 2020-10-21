package com.example.mybatisplus02.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 谢逸民
 * @Date 2020/6/6 9:30
 * @Desciption
 */
@Data
@ApiModel(value = "SearchCondition实体", description = "搜索参数实体")
public class SearchCondition {
    @ApiModelProperty(value = "页数", required = true)
    private int pageNo;
    @ApiModelProperty(value = "每页数量", required = true)
    private int pageSize;
    @ApiModelProperty(value = "排序字段")
    private String orderColumn;
    @ApiModelProperty(value = "排序类型")
    private String orderDir;
    @ApiModelProperty(value = "搜索参数,后端map接收")
    private Map<String, Object> param = new HashMap<String, Object>();
}