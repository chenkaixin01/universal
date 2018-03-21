package com.chenkx.universal.modular.system.controller;

import com.chenkx.universal.common.annotion.BussinessLog;
import com.chenkx.universal.common.annotion.Permission;
import com.chenkx.universal.common.constant.Const;
import com.chenkx.universal.common.constant.dictmap.ScheduleConfigDict;
import com.chenkx.universal.core.base.controller.BaseController;
import com.chenkx.universal.core.util.ToolUtil;
import com.chenkx.universal.modular.job.StartJob;
import com.chenkx.universal.modular.system.service.ISchedulerConfigService;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.chenkx.universal.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.chenkx.universal.common.persistence.model.SchedulerConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 定时调度配置管理控制器
 *
 * @author chenkx
 * @Date 2018-03-09 10:20:29
 */
@Controller
@RequestMapping("/scheduler")
public class SchedulerConfigController extends BaseController {

    private String PREFIX = "/system/scheduler/";

    @Autowired
    private ISchedulerConfigService schedulerConfigService;

    /**
     * 跳转到定时调度配置管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "scheduler.html";
    }

    /**
     * 跳转到添加定时调度配置管理
     */
    @RequestMapping("/scheduler_add")
    public String schedulerAdd() {
        return PREFIX + "scheduler_add.html";
    }

    /**
     * 跳转到修改定时调度配置管理
     */
    @RequestMapping("/scheduler_update/{schedulerId}")
    public String schedulerUpdate(@PathVariable Integer schedulerId, Model model) {
        SchedulerConfig schedulerConfig = schedulerConfigService.selectById(schedulerId);
        model.addAttribute("item",schedulerConfig);
        LogObjectHolder.me().set(schedulerConfig);
        return PREFIX + "scheduler_edit.html";
    }

    /**
     * 获取定时调度配置管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return schedulerConfigService.selectList(null);
    }

    /**
     * 新增定时调度配置管理
     */
    @RequestMapping(value = "/add")
    @BussinessLog(value = "添加调度", key = "name", dict = ScheduleConfigDict.class)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object add(SchedulerConfig schedulerConfig) throws ClassNotFoundException, SchedulerException {
        schedulerConfigService.insert(schedulerConfig);
        String name = schedulerConfig.getName();
        String group = schedulerConfig.getSchedulerGroup();
        String cron = schedulerConfig.getCron();
        Class runJob = Class.forName(schedulerConfig.getName());
        String initParamStr = schedulerConfig.getInitParam();
        Map<String,String> dataMap = new HashMap<>();
        if(ToolUtil.isNotEmpty(initParamStr)) {
            String[] initParam = initParamStr.split("#");
            for (int i = 1; i < initParam.length; i++) {
                dataMap.put(i + "", initParam[i - 1]);
            }
        }
        new StartJob().addOneJob(name,group,cron,runJob,dataMap);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除定时调度配置管理
     */
    @RequestMapping(value = "/delete")
    @BussinessLog(value = "删除调度", key = "name", dict = ScheduleConfigDict.class)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object delete(@RequestParam Integer schedulerId) throws SchedulerException {
        SchedulerConfig schedulerConfig = schedulerConfigService.selectById(schedulerId);
        new StartJob().deleteJob(schedulerConfig.getName(),schedulerConfig.getSchedulerGroup());
        schedulerConfigService.deleteById(schedulerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改定时调度配置管理
     */
    @RequestMapping(value = "/update")
    @BussinessLog(value = "修改调度", key = "name", dict = ScheduleConfigDict.class)
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object update(SchedulerConfig schedulerConfig) throws ClassNotFoundException, SchedulerException {
        schedulerConfigService.updateById(schedulerConfig);
        String name = schedulerConfig.getName();
        String group = schedulerConfig.getSchedulerGroup();
        String cron = schedulerConfig.getCron();
        Class runJob = Class.forName(schedulerConfig.getName());
        String initParamStr = schedulerConfig.getInitParam();
        Map<String,String> dataMap = new HashMap<>();
        if(ToolUtil.isNotEmpty(initParamStr)) {
            String[] initParam = initParamStr.split("#");
            for (int i = 1; i < initParam.length; i++) {
                dataMap.put(i + "", initParam[i - 1]);
            }
        }
            new StartJob().updateJob(name,group,cron,runJob,dataMap);
        return super.SUCCESS_TIP;
    }

    /**
     * 定时调度配置管理详情
     */
    @RequestMapping(value = "/detail/{schedulerId}")
    @ResponseBody
    public Object detail(@PathVariable("schedulerId") Integer schedulerId) {
        return schedulerConfigService.selectById(schedulerId);
    }
}
