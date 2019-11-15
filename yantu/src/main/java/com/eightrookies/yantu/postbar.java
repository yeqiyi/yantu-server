package com.eightrookies.yantu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIE")
public class postbar {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERNAME")
    private String user_id;
    @Column(name = "TDATE")
    private String date;
    @Column(name = "FN")
    private String content;
    @Column(name = "DZS")
    private Integer zan;
    @Column(name = "PLS")
    private Integer pl;
    @OneToMany(mappedBy = "tid",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<replys> replysList=new ArrayList<>();

    public Integer getPl() {
        return pl;
    }

    public void setPl(Integer pl) {
        this.pl = pl;
    }

    public List<replys> getReplysList() {

        return replysList;
    }

    public void setReplysList(List<replys> replysList) {
        this.replysList = replysList;
    }

    public postbar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFn() {
        return content;
    }

    public void setFn(String fn) {
        this.content = fn;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }
}
