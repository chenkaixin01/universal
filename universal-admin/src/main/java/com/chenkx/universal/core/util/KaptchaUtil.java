package com.chenkx.universal.core.util;

import com.chenkx.universal.config.properties.UniversalProperties;
import com.chenkx.universal.config.properties.UniversalProperties;
import com.chenkx.universal.config.properties.UniversalProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     *
     * @author chenkx
     * @Date 2017/5/23 22:34
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(UniversalProperties.class).getKaptchaOpen();
    }
}