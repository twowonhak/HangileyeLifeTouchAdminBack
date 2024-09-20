package com.hangileye.lifetouch.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/*********************************************************************
    cors 관련 설정을 포함한 필터.
    기본적으로 서버 또는 지정된 특정 도메인의 요청만 허용하지만
    프론트가 정해져있지 않기 때문에 모든 도메인을 허용하는 방식으로 설정.
*********************************************************************/
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   // 내 서버가 응답을 할 때 json을 자바스크립트에서 처리할수 있게 할지를 설정
        //config.addAllowedOrigin("*"); // java.lang.IllegalArgumentException: When allowCredentials is true, allowedOrigins cannot contain the special value "*" since that cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins, list them explicitly or consider using "allowedOriginPatterns" instead.
        config.addAllowedOriginPattern("*"); // 허용할 도메인 목록 e.g. http://domain1.com
        config.addAllowedHeader("*");   // 허용할 헤더 목록
        config.addAllowedMethod("*");   // 허용할 메서드(GET, PUT, 등) 목록
        config.setExposedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,RefreshToken,Content-Disposition"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);    // 지정한 url에 config 적용

        return new CorsFilter(source);
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}