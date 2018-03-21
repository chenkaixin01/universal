package com.chenkx.universal.modular.system.service.impl;

import com.chenkx.universal.common.persistence.dao.SchedulerConfigMapper;
import com.chenkx.universal.common.persistence.model.SchedulerConfig;
import com.chenkx.universal.modular.system.service.ISchedulerConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时调度表 服务实现类
 * </p>
 *
 * @author chenkx123
 * @since 2018-03-09
 */
@Service
public class SchedulerConfigServiceImpl extends ServiceImpl<SchedulerConfigMapper, SchedulerConfig> implements ISchedulerConfigService {

}
