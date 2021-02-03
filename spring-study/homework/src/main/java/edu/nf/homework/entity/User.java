package edu.nf.homework.entity;

/**
 * @author 天文学
 * @date 2020/12/21
 */
public class User {
    private Integer uid;
    private String name;

    public User() {
    }

    public User(Integer uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
