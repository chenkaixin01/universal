package com.chenkx.universal.common.constant.dictmap;

import com.chenkx.universal.common.constant.dictmap.base.AbstractDictMap;

public class ScheduleConfigDict extends AbstractDictMap {
    @Override
    public void init() {
        put("name","定时调度名称");
        put("cron","定时时间");
        put("initParam","初始化参数");
        put("paramDesc","初始化参数描述");
        put("jobClass","Job路径");
        put("schedulerGroup","调用分组");
        put("url","访问地址");
        put("tokenUrl","tocken地址");
        put("connType","访问方式");
        put("remark","备注");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("connType","访问方式");
    }
}
