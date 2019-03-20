package com.spring.application;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
        //关闭Springboot的console打印
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
//        System.out.println("springboot");
//        String name = ParamController.class.getPackage().getName();
//        System.out.println(name);
    }
}
