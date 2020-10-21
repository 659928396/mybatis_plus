package com.example.mybatisplus02.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjie
 * @Date: 2020/10/13 16:58
 */
@Configuration
@MapperScan("com.example.mybatisplus02.mapper")
public class MybatisPlusConfig {
    public static ThreadLocal<String> SYS_TYPE = new ThreadLocal<String>();//租户信息

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();//mybatisplus3.4后新增的
        //1 分页设置
//        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL); //这个新版的内置分页拦截器与动态表名拦截器一起使用时，会导致动态表名设置失效，所以注释掉这里
//        interceptor.addInnerInterceptor(paginationInnerInterceptor);

        //2 多租户动态表名设置
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        Map<String, TableNameHandler> tableNameHandlerMap = new HashMap<String, TableNameHandler>();
        tableNameHandlerMap.put("common_post", new TableNameHandler() {//表名不能写错，否则将无法动态替换掉表名
            @Override
            public String dynamicTableName(String sql, String tableName) {
                return SYS_TYPE.get() + "_post";
            }
        });
        //如需替换更多表名，继续编写往tableNameHandlerMap设置需替换的表名即可
        dynamicTableNameInnerInterceptor.setTableNameHandlerMap(tableNameHandlerMap);
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);

        return interceptor;
    }

    /**
     * 分页插件 MybatisPlus3.4之后不推荐，但是新的内置分页拦截器PaginationInnerInterceptor与动态表名拦截器DynamicTableNameInnerInterceptor组合使用失败，因此分页插件还是使用旧版的
     *
     * @return 分页插件的实例
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
