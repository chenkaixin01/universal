/**
 * 初始化定时调度配置管理详情对话框
 */
var SchedulerInfoDlg = {
    schedulerInfoData : {}
};

/**
 * 清除数据
 */
SchedulerInfoDlg.clearData = function() {
    this.schedulerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SchedulerInfoDlg.set = function(key, val) {
    this.schedulerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SchedulerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SchedulerInfoDlg.close = function() {
    parent.layer.close(window.parent.Scheduler.layerIndex);
}

/**
 * 收集数据
 */
SchedulerInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('cron')
    .set('initParam')
    .set('paramDesc')
    .set('jobClass')
    .set('schedulerGroup')
    .set('url')
    .set('tokenUrl')
    .set('connType')
    .set('remark');
}

/**
 * 提交添加
 */
SchedulerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/scheduler/add", function(data){
        Feng.success("添加成功!");
        window.parent.Scheduler.table.refresh();
        SchedulerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.schedulerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SchedulerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/scheduler/update", function(data){
        Feng.success("修改成功!");
        window.parent.Scheduler.table.refresh();
        SchedulerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.schedulerInfoData);
    ajax.start();
}

$(function() {

});
