package com.chenkx.universal.system;

public class Student {
    private String name;
    private String sex;

    public Student(String name, String sex) {
        super();
        this.name = name;
        this.sex = sex;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}