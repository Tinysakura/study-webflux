package com.cfh.studywebflux.router;

import com.cfh.studywebflux.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author: chenfeihao@corp.netease.com
 * @Date: 2018/11/18
 */
@Configuration
public class RouterConfig {
    @Autowired
    TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/time"), req -> timeHandler.getTime(req))
                .andRoute(RequestPredicates.GET("/times"), timeHandler::getTimes);
    }
}