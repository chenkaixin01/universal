package com.chenkx.universal.generator.engine.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Job代码生成配置
 */
public class JobConfig {

    private ContextConfig contextConfig;

    private String jobPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init(){
        ArrayList<String> imports = new ArrayList<>();
        imports.add(contextConfig.getProPackage() + ".core.log.LogObjectHolder");
        imports.add("java.util.Map");
        imports.add("java.util.HashMap");
        imports.add("org.quartz.Job");
        imports.add("org.quartz.JobExecutionContext");
        imports.add("org.quartz.JobExecutionException");
        imports.add(contextConfig.getProPackage() + ".job."+"client." + contextConfig.getEntityName() + "JobClient");

        this.imports = imports;
        this.packageName = contextConfig.getProPackage() +  ".job."+"jobClaz";
        this.jobPathTemplate = "\\src\\main\\java\\"+contextConfig.getProPackage().replaceAll("\\.","\\\\")+"\\job\\" + "\\jobClaz\\{}Job.java";
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }

    public String getJobPathTemplate() {
        return jobPathTemplate;
    }

    public void setJobPathTemplate(String jobPathTemplate) {
        this.jobPathTemplate = jobPathTemplate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }
}
