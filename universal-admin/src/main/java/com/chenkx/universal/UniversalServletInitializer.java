package com.chenkx.universal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Universal Web程序启动类
 *
 * @author chenkx
 * @date 2017-05-21 9:43
 */
public class UniversalServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UniversalApplication.class);
    }

}
