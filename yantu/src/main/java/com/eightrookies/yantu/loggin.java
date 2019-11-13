package com.eightrookies.yantu;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class loggin {
    @Autowired
    private accountRepository areposity;

    private String verifycode;
    @PostMapping("/password")
    public Object login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password")String password) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        users userForbase=areposity.findByTel(phone);
        if(userForbase==null){
            jsonObject.put("message","用户名不存在！");
            return jsonObject;
        }else{
            if(!userForbase.getPassword().trim().equals(password.trim())){
                jsonObject.put("message","登录失败，密码错误");
                return jsonObject;
            }
            else{
                jsonObject.put("message","登录成功！");
                String token=getToken(userForbase);
                jsonObject.put("token",token);
                jsonObject.put("user",userForbase);
                return jsonObject;
            }
        }
    }
    public String getToken(users user) {
        String token="";
        token= JWT.create().withAudience(user.getPhone())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
