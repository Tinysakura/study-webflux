package com.cfh.studywebflux.handler;

import com.sun.security.ntlm.Server;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * @Author: chenfeihao@corp.netease.com
 * @Date: 2018/11/18
 */
@Component
public class TimeHandler {

    public Mono<ServerResponse> getTime (ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("now is " + new SimpleDateFormat("HH:MM:ss").format(new Date())), String.class);
    }

    /**
     * SSE流推送
     */
    public Mono<ServerResponse> getTimes (ServerRequest request) {
        // 使用Flux的interval方法每秒生成一个流
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1)).map(l -> new SimpleDateFormat("HH:MM:ss").format(new Date())), String.class);
    }

}