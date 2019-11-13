package com.eightrookies.yantu;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class users {

    @Column(name = "PW",nullable = false)
    private String password;
    @Id
    private String tel;
    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "MAJOR",nullable = false)
    private Integer major;
    @Column(name = "YEARS",nullable = false)
    private Integer years;
    @Column(name = "UPLAN")
    private Integer uplan;
    @Column(name = "HEAD")
    private String head;
    public users() {
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return tel;
    }

    public void setPhone(String phone) {
        this.tel = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getUplan() {
        return uplan;
    }

    public void setUplan(Integer uplan) {
        this.uplan = uplan;
    }
}
