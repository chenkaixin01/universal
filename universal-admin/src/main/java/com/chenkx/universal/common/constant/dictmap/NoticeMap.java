package com.chenkx.universal.common.constant.dictmap;

import com.chenkx.universal.common.constant.dictmap.base.AbstractDictMap;
import com.chenkx.universal.common.constant.dictmap.base.AbstractDictMap;
import com.chenkx.universal.common.constant.dictmap.base.AbstractDictMap;

/**
 * 通知的映射
 *
 * @author chenkx
 * @date 2017-05-06 15:01
 */
public class NoticeMap extends AbstractDictMap {

    @Override
    public void init() {
        put("title", "标题");
        put("content", "内容");
    }

    @Override
    protected void initBeWrapped() {
    }
}
