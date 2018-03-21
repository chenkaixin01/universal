package com.chenkx.universal.modular.system.factory;

import com.chenkx.universal.modular.system.transfer.UserDto;
import com.chenkx.universal.modular.system.transfer.UserDto;
import com.chenkx.universal.common.persistence.model.User;
import com.chenkx.universal.modular.system.transfer.UserDto;
import org.springframework.beans.BeanUtils;

/**
 * 用户创建工厂
 *
 * @author chenkx
 * @date 2017-05-05 22:43
 */
public class UserFactory {

    public static User createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
