package com.cfh.studywebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author: chenfeihao@corp.netease.com
 * @Date: 2018/11/18
 * 响应式spring的入门例子
 */
@RestController
public class HelloWorldController {
    @GetMapping("/hello_world")
    public Mono<String> helloWorld() {
        return Mono.just("hello world");
    }
}