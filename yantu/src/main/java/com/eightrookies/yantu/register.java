package com.eightrookies.yantu;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class register {
    @Autowired
    private accountRepository repository;
    @PostMapping("/register")
    public Object addusers(@RequestParam(value = "phone")String phone,@RequestParam("password")String password,@RequestParam("name")String name,@RequestParam("major")Integer major,@RequestParam("years")Integer year){
        JSONObject jsonObject=new JSONObject();

        if(repository.findByTel(phone)==null) {
            repository.adduser(phone, password, name, major, year);
            jsonObject.put("message","注册成功！");
        }else{
            jsonObject.put("message","注册失败，用户已存在！");
        }
        return jsonObject;
    }
}