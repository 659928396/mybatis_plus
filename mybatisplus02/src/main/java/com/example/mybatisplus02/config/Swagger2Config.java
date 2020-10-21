package com.example.mybatisplus02.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Swagger 配置类
 */
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Configuration
public class Swagger2Config {

    @Value("${swagger2.enable}")
    private Boolean enable;

    @Bean
    public Docket createRestApi() {
        // 定义全局header参数
        List<Parameter> pars = new ArrayList<>();
        /*ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder appIdPar = new ParameterBuilder();
        tokenPar.name("token").defaultValue("").description("访问身份令牌").modelRef(new ModelRef("string"))
                .parameterType("header").required(true).build();
        appIdPar.name("appId").defaultValue("1").description("appId").modelRef(new ModelRef("string"))
                .parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        pars.add(appIdPar.build());*/

        ParameterBuilder sysTypePar = new ParameterBuilder();
        sysTypePar.name("sysType").defaultValue("").description("系统类型").modelRef(new ModelRef("string"))
                .parameterType("header").required(true).build();
        pars.add(sysTypePar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                // 这里配置要扫描的包,接口在哪个包就配置哪个包
                .apis(RequestHandlerSelectors.basePackage("com.example.mybatisplus02.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //接口文档的名字
                .title("基础模块")
                //接口文档的描述
                .description("基础模块-api接口文档")
                //服务条款网址
                .termsOfServiceUrl("http://127.0.0.1/")
                //接口文档的版本
                .version("1.0.0")
                // 接口文档维护联系信息
                .contact(new Contact("梁杰", "", ""))
                .build();
    }

}