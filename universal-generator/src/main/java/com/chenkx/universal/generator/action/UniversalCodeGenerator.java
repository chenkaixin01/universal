package com.chenkx.universal.generator.action;


import com.chenkx.universal.generator.action.config.UniversalGeneratorConfig;

/**
 * 代码生成器,可以生成实体,dao,service,controller,html,js
 *
 * @author chenkx
 * @Date 2017/5/21 12:38
 */
public class UniversalCodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        UniversalGeneratorConfig universalGeneratorConfig = new UniversalGeneratorConfig();
        universalGeneratorConfig.doMpGeneration();

        /**
         * universal的生成器:
         *      universal的代码生成器可以生成controller,html页面,页面对应的js
         */
        universalGeneratorConfig.doUniversalGeneration();
    }

}