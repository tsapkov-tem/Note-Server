package com.example.note.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableWebMvc
public class SwaggerConfig {


    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo getInfo(){
        return new ApiInfoBuilder().title("Tsapkov-tem")
                .description("Info about this server")
                .license("tsapkov-tem")
                .build();
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
}
