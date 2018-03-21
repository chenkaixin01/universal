package com.chenkx.universal;

import com.chenkx.universal.config.properties.UniversalProperties;
import com.chenkx.universal.modular.job.StartJob;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.UnknownHostException;

/**
 * SpringBoot方式启动类
 *
 * @author chenkx
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class UniversalApplication extends WebMvcConfigurerAdapter {

    protected final static Logger logger = LoggerFactory.getLogger(UniversalApplication.class);

    @Autowired
    UniversalProperties universalProperties;

    /**
     * 增加swagger的支持
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (universalProperties.getSwaggerOpen()) {
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

    public static void main(String[] args) throws SchedulerException, ClassNotFoundException, UnknownHostException {
        SpringApplication.run(UniversalApplication.class, args);
        logger.info("UniversalApplication is success!");
        new StartJob().startAllJob();
        logger.info("定时调度启动");
    }
}
