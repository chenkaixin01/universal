package com.chenkx.universal.system;

public class People {
    private String name;
    private String sex;

    public People(String name, String sex) {
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
