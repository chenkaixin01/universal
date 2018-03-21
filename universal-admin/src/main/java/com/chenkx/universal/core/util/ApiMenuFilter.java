package com.chenkx.universal.core.util;

import com.chenkx.universal.common.constant.Const;
import com.chenkx.universal.config.properties.UniversalProperties;
import com.chenkx.universal.common.constant.Const;
import com.chenkx.universal.config.properties.UniversalProperties;
import com.chenkx.universal.core.node.MenuNode;
import com.chenkx.universal.common.constant.Const;
import com.chenkx.universal.config.properties.UniversalProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * api接口文档显示过滤
 *
 * @author chenkx
 * @date 2017-08-17 16:55
 */
public class ApiMenuFilter extends MenuNode {


    public static List<MenuNode> build(List<MenuNode> nodes) {

        //如果关闭了接口文档,则不显示接口文档菜单
        UniversalProperties universalProperties = SpringContextHolder.getBean(UniversalProperties.class);
        if (!universalProperties.getSwaggerOpen()) {
            List<MenuNode> menuNodesCopy = new ArrayList<>();
            for (MenuNode menuNode : nodes) {
                if (Const.API_MENU_NAME.equals(menuNode.getName())) {
                    continue;
                } else {
                    menuNodesCopy.add(menuNode);
                }
            }
            nodes = menuNodesCopy;
        }

        return nodes;
    }
}
