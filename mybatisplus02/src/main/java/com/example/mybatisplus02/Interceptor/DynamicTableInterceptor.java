package com.example.mybatisplus02.Interceptor;

import com.example.mybatisplus02.config.MybatisPlusConfig;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置租户编码拦截器
 *      设置租户编码MybatisPlusConfig.SYS_TYPE，可实现不同租户的表之间的切换
 * @author liangjie
 * @date 2020.10.16
 */
public class DynamicTableInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sysType = request.getHeader("sysType");
        MybatisPlusConfig.SYS_TYPE.set(sysType);//设置租户
        return true;
    }

}
