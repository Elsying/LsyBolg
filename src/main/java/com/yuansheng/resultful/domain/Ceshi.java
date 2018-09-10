package com.yuansheng.resultful.domain;

public class Ceshi {
    Integer id;
    String name;
    String sex;
    String code;

    public Ceshi(int id, String name, String sex, String code) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
