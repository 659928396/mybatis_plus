package com.example.mybatisplus02.domain.vo;

import com.example.mybatisplus02.constant.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResultVO {
    /**
     * 状态码，比如200代表响应成功
     */
    @ApiModelProperty(value = "状态码", notes = "默认200是成功")
    private Integer code;
    /**
     * 响应信息，用来说明响应情况
     */
    @ApiModelProperty(value = "响应信息", notes = "来说明响应情况")
    private String message;
    /**
     * 响应的具体数据
     */
    @ApiModelProperty(value = "响应的具体数据")
    private Object data;

    public ResultVO() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");
    }

    public ResultVO(ResultCode code, Object data) {
        this.setCode(code);
        this.setData(data);
    }

    public ResultVO(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ResultVO(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public ResultVO(ResultCode code, String message, String data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
