package com.example.mybatisplus02.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 通用贴吧管理
 * </p>
 *
 * @author liangjie
 * @since 2020-10-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="CommonPostVO", description="通用贴吧管理")
public class CommonPostVO implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long gid;

    @ApiModelProperty(value = "第三方关联表ID")
    private String thirdTableId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "作品标签")
    private String labels;

    @ApiModelProperty(value = "作品内容")
    private String content;

    @ApiModelProperty(value = "生成时间")
    private Date createTime;

    @ApiModelProperty(value = "生成用户ID")
    private String createUserId;

    @ApiModelProperty(value = "生成用户名")
    private String createUserName;

    @ApiModelProperty(value = "最后修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "最后修改用户ID")
    private String modifyUserId;

    @ApiModelProperty(value = "最后修改用户名")
    private String modifyUserName;

    @ApiModelProperty(value = "删除时间")
    private String deleteTime;

    @ApiModelProperty(value = "删除用户ID")
    private String deleteUserId;

    @ApiModelProperty(value = "删除用户名")
    private String deleteUserName;

    @ApiModelProperty(value = "删除标识")
    private String deleteFlag;

}
