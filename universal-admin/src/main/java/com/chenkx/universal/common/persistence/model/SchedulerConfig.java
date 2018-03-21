package com.chenkx.universal.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 定时调度表
 * </p>
 *
 * @author chenkx123
 * @since 2018-03-09
 */
@TableName("sys_scheduler_config")
public class SchedulerConfig extends Model<SchedulerConfig> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 调度名
     */
    private String name;
    /**
     * cron表达式
     */
    private String cron;
    /**
     * 初始化参数,以#号隔开
     */
    @TableField("init_param")
    private String initParam;
    /**
     * 初始化参数描述
     */
    @TableField("param_desc")
    private String paramDesc;
    /**
     * Job类的全路径
     */
    @TableField("job_class")
    private String jobClass;
    /**
     * 调用分组
     */
    @TableField("scheduler_group")
    private String schedulerGroup;
    /**
     * 调用地址
     */
    private String url;
    @TableField("token_url")
    private String tokenUrl;
    @TableField("conn_type")
    private Integer connType;
    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getInitParam() {
        return initParam;
    }

    public void setInitParam(String initParam) {
        this.initParam = initParam;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getSchedulerGroup() {
        return schedulerGroup;
    }

    public void setSchedulerGroup(String schedulerGroup) {
        this.schedulerGroup = schedulerGroup;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public Integer getConnType() {
        return connType;
    }

    public void setConnType(Integer connType) {
        this.connType = connType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Scheduler{" +
        "id=" + id +
        ", name=" + name +
        ", cron=" + cron +
        ", initParam=" + initParam +
        ", paramDesc=" + paramDesc +
        ", jobClass=" + jobClass +
        ", schedulerGroup=" + schedulerGroup +
        ", url=" + url +
        ", tokenUrl=" + tokenUrl +
        ", connType=" + connType +
        ", remark=" + remark +
        "}";
    }
}
