/**
 * 定时调度配置管理管理初始化
 */
var Scheduler = {
    id: "SchedulerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Scheduler.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '调度名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: 'cron表达式', field: 'cron', visible: true, align: 'center', valign: 'middle'},
            {title: '初始化参数', field: 'initParam', visible: true, align: 'center', valign: 'middle'},
            {title: '初始化参数描述', field: 'paramDesc', visible: true, align: 'center', valign: 'middle'},
            {title: 'Job路径', field: 'jobClass', visible: true, align: 'center', valign: 'middle'},
            {title: '调用分组', field: 'schedulerGroup', visible: true, align: 'center', valign: 'middle'},
            {title: '调用地址', field: 'url', visible: true, align: 'center', valign: 'middle'},
            {title: 'token获取地址', field: 'tokenUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '访问方式', field: 'connType', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Scheduler.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Scheduler.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加定时调度配置管理
 */
Scheduler.openAddScheduler = function () {
    var index = layer.open({
        type: 2,
        title: '添加定时调度配置管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/scheduler/scheduler_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看定时调度配置管理详情
 */
Scheduler.openSchedulerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '定时调度配置管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/scheduler/scheduler_update/' + Scheduler.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除定时调度配置管理
 */
Scheduler.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/scheduler/delete", function (data) {
            Feng.success("删除成功!");
            Scheduler.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("schedulerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询定时调度配置管理列表
 */
Scheduler.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Scheduler.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Scheduler.initColumn();
    var table = new BSTable(Scheduler.id, "/scheduler/list", defaultColunms);
    table.setPaginationType("client");
    Scheduler.table = table.init();
});
