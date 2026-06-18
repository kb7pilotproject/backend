package org.scoula.carrotmarket.config;
// Service, DAO, Security, DB
// 어노테이션이 붙은 클래스들을 자동으로 찾아 빈으로 등록
// SecurityConfig와 DBConfig를 가져와서 합치기

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

// Service, DAO, Security, DB
@Configuration
@PropertySource("classpath:application.properties")
// 어노테이션이 붙은 클래스들을 자동으로 찾아 빈으로 등록 (Controller는 WebMvcConfig가 따로 스캔하므로 제외)
// Service,DAO
@ComponentScan(
        basePackages = "org.scoula.carrotmarket",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
        }
)
// Security, DB
@Import({ SecurityConfig.class, RootConfig.class })
public class ServletConfig {
}
