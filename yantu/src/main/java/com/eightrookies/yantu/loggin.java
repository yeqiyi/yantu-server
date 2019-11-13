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
    @RequestMapping("/verifycode")
    public @ResponseBody Map<String,Object> verifycode(@RequestParam(value = "phone")String phone, HttpServletRequest request){
        Map<String,Object>map =new HashMap<String, Object>();
        boolean smsSucess=false;
        try{
            if(phone==null){
                map.put("message","手机号不能为空");
                map.put("result","error");
                return map;
            }

            verifycode=RandomCodeUtil.getRandomNumber(6);
            String msg="【研途】 您的短信验证码是："+verifycode+"  您正在进行用户验证操作，如非本人操作，请忽略该短信。";
        }
    }
    public String getToken(users user) {
        String token="";
        token= JWT.create().withAudience(user.getPhone())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
    @UserLoginToken
    @GetMapping("/getmsg")
    public String getMsg(){
        return "通过验证";
    }
}
