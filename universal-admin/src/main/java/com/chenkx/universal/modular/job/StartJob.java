package com.chenkx.universal.modular.job;

import com.chenkx.universal.common.persistence.model.SchedulerConfig;
import com.chenkx.universal.core.util.ServiceInfoUtil;
import com.chenkx.universal.core.util.ToolUtil;
import com.chenkx.universal.modular.system.service.ISchedulerConfigService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.CronCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 添加定时调度,并启动
 */
public class StartJob {
    protected final static Logger logger = LoggerFactory.getLogger(StartJob.class);
    @Autowired
    private ISchedulerConfigService schedulerConfigService;
    private Scheduler scheduler = null;
    public StartJob() throws SchedulerException {
        StdSchedulerFactory factory = new StdSchedulerFactory();
        this.scheduler = factory.getScheduler();
    }
    public void startAllJob() throws UnknownHostException, SchedulerException, ClassNotFoundException {
        logger.info("初始化启动调度..................");
        String port ="";
        String ip = "";
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostAddress();
            port = String.valueOf(ServiceInfoUtil.getPort());
            logger.info("服务器ip:"+ip+"  端口port:"+port);
        scheduler.standby();
        Map<String,Object> map = new HashMap<>();
        map.put("SchedulerGroup",ip+":"+port);
        List<SchedulerConfig> jobs = schedulerConfigService.selectByMap(map);
        Integer num = jobs==null?0:jobs.size();
        if(jobs!=null&&!jobs.isEmpty()){
            for (SchedulerConfig job:jobs ) {
                String name = job.getName();
                String group = job.getSchedulerGroup();
                String cron = job.getCron();
                Class runJob = Class.forName(job.getName());
                String initParamStr = job.getInitParam();
                Map<String,String> dataMap = new HashMap<>();
                if(ToolUtil.isNotEmpty(initParamStr)){
                    String[] initParam = initParamStr.split("#");
                    for(int i=1;i<initParam.length;i++){
                        dataMap.put(i+"",initParam[i-1]);
                    }
                    addJob(name,group,cron,runJob,dataMap);
                }
            }
            scheduler.start();
        }
    }

    public void addOneJob(String jobName, String jobGroup, String cron, Class<? extends Job> clazz,
                          Map<String, String> dataMap) throws SchedulerException {
        addJob(jobName,jobGroup,cron,clazz,dataMap);
        if(scheduler.isShutdown()){
            scheduler.start();
        }
    }

    public void updateJob(String jobName, String jobGroup, String cron, Class<? extends Job> clazz,
                          Map<String, String> dataMap) throws SchedulerException {
        deleteJob(jobName,jobGroup);
        addJob(jobName,jobGroup,cron,clazz,dataMap);
        if(scheduler.isShutdown()){
            scheduler.start();
        }
    }

    private void addJob(String jobName, String jobGroup, String cron, Class<? extends Job> clazz,
                   Map<String, String> dataMap ) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobName,jobGroup).build();
        if(ToolUtil.isNotEmpty(dataMap)){
            jobDetail.getJobDataMap().putAll(dataMap);
        }
        CronTrigger trgOne = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        scheduler.scheduleJob(jobDetail,trgOne);
    }
    public void deleteJob(String jobName,String groupName) throws SchedulerException {
        scheduler.deleteJob(JobKey.jobKey(jobName, groupName));
    }

}
