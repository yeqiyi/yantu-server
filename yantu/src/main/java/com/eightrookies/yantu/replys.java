package com.eightrookies.yantu;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "RES")
public class replys {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "RTIME")
    private String date;
    @Column(name = "PN")
    private String pn;
    @Column(name = "USERNAME")
    private String name;
    @Column(name="TID")
    private Integer tid;
    public replys() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

}
