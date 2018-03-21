package com.chenkx.universal.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * spring session配置
 *
 * @author chenkx
 * @date 2017-07-13 21:05
 */
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)  //session过期时间  如果部署多机环境,需要打开注释
@ConditionalOnProperty(prefix = "universal", name = "spring-session-open", havingValue = "true")
public class SpringSessionConfig {


}
