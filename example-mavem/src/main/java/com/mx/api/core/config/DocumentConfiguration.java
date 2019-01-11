package com.mx.api.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2016/3/29.
 */


@Configuration
@EnableSwagger2
public class DocumentConfiguration {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.mx.api";
    public static final String VERSION = "V2";

    @Bean
    public Docket apiForDev() {
        return docket();
    }

    private Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(Errors.class)
                .select()
//                .apis(RequestHandlerSelectors.basePackage(GisController.class.getPackage().getName()))
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))//api接口扫描宝路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger 接口文档示例")//设置文档标题
                .description("接口模拟测试")
                .version(VERSION)
                .build();
    }
}
