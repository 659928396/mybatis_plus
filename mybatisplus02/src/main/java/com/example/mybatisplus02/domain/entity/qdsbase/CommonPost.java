package com.example.mybatisplus02.domain.entity.qdsbase;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 通用贴吧管理
 * </p>
 *
 * @author liangjie
 * @since 2020-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CommonPost对象", description="通用贴吧管理")
public class CommonPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "gid", type = IdType.AUTO)
    private Long gid;

    @ApiModelProperty(value = "第三方关联表主键")
    @TableField("thirdTableId")
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
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "生成用户ID")
    @TableField("createUserId")
    private Long createUserId;

    @ApiModelProperty(value = "生成用户名")
    @TableField("createUserName")
    private String createUserName;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("modifyTime")
    private Date modifyTime;

    @ApiModelProperty(value = "最后修改用户ID")
    @TableField("modifyUserId")
    private Long modifyUserId;

    @ApiModelProperty(value = "最后修改用户名")
    @TableField("modifyUserName")
    private String modifyUserName;

    @ApiModelProperty(value = "删除时间")
    @TableField("deleteTime")
    private String deleteTime;

    @ApiModelProperty(value = "删除用户ID")
    @TableField("deleteUserId")
    private Long deleteUserId;

    @ApiModelProperty(value = "删除用户名")
    @TableField("deleteUserName")
    private String deleteUserName;

    @ApiModelProperty(value = "删除标识")
    @TableField("deleteFlag")
    private String deleteFlag;


}
