package com.chenkx.universal.system;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class ceshi {
    public static void main(String[] args) {
        Student student1 = new Student("张三", "男");
        Student student = new Student("小红", "女");
        People people = new People("李四", "男");
        Map<String,Object> map =new HashMap<String, Object>();
        List list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        map.put("xuesheng", list);
        String json = JSON.toJSONString(map);
        System.out.println(json);
        List<Student> list2 = JSON.parseObject("[{\"name\":\"小红\",\"sex\":\"女\"},{\"name\":\"张三\",\"sex\":\"男\"}]", List.class);
        System.out.println(list2);
    }
}
