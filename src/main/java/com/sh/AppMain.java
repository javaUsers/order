package com.sh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * author: xiaomo
 * github: https://github.com/syoubaku
 * email: hupengbest@163.com
 * QQ_NO: 83387856
 * Date: 2017/2/28 下午3:52
 * Description:
 * Copyright(©) 2017 by xiaomo.
 **/
@Controller
@EnableAutoConfiguration
@ComponentScan("com.sh")
@EntityScan("com.sh.model")
@EnableTransactionManagement
@EnableJpaRepositories("com.sh.dao")
public class AppMain {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppMain.class, args);
    }

    @Bean
    public DefaultAnnotationHandlerMapping setReq(){
        DefaultAnnotationHandlerMapping mapping = new DefaultAnnotationHandlerMapping();
        mapping.setUseDefaultSuffixPattern(false);
        return mapping;
    }

}
