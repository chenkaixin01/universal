package com.chenkx.universal.system;

import com.chenkx.universal.base.BaseJunit;
import com.chenkx.universal.common.persistence.dao.UserMapper;
import com.chenkx.universal.modular.system.dao.UserMgrDao;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * 用户测试
 *
 * @author chenkx
 * @date 2017-04-27 17:05
 */
public class UserTest extends BaseJunit {

    @Resource
    UserMgrDao userMgrDao;

    @Resource
    UserMapper userMapper;

    @Test
    public void userTest() throws Exception {

    }

}
