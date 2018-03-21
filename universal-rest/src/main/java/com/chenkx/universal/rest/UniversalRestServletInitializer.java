package com.chenkx.universal.rest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Universal REST Web程序启动类
 *
 * @author chenkx
 * @date 2017年9月29日09:00:42
 */
public class UniversalRestServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UniversalRestApplication.class);
    }

}
