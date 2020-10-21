package com.example.mybatisplus02.config;

import com.example.mybatisplus02.Interceptor.DynamicTableInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 拦截器定义
 *
 * @author
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    // 让bean提前加载，让拦截器中的@Autowired生效
    // 在拦截器中使用了RedisUtil bean类，但是拦截器执行实在spring容器bean初始化之前的
    // RedisUtil 将无法注入，为了解决该问题，将JwtInterceptor拦截器先配置为一个bean
    // 在注册拦截器时，直接使用配置的bean
    @Bean
    public DynamicTableInterceptor dynamicTableInterceptor() {
        return new DynamicTableInterceptor();
    }

    /**
     * 可定义多个拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 定义过滤拦截的url名称，拦截所有请求
        registry.addInterceptor(dynamicTableInterceptor())
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }

    /**
     * 建议使用该方法进行HttpMessageConverters的修改，此时的converters已经是Spring初始化过的
     * 因为加入了WebMvcConfigure，导致Spring的HttpMessageConverters中的String转换类默认使用ISO-8859-1编码
     * 所以这里对Spring已经初始化过的StringHttpMessageConverter的编码进行修改
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(converter ->{
            if(converter instanceof StringHttpMessageConverter){
                ((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
            }
        });
        super.extendMessageConverters(converters);
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书
                .allowCredentials(true)
                //设置允许的方法,GET/POST/PUT/DELETE
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
        super.addCorsMappings(registry);
    }

}
