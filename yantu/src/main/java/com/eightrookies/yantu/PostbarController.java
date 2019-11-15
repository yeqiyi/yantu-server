package com.eightrookies.yantu;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
@RestController
public class PostbarController {
    @Autowired
    PbRepository pbRepository;
    @Autowired
    accountRepository arepository;
    @Autowired
    ReplyRepository replyRepository;
    //查询帖子列表
    @GetMapping("/tie")
    public List<postbar> postbars(){
        return pbRepository.findAll();
    }
    //查询帖子
    @PostMapping("/{id}/tie")
    public postbar pb(@PathVariable("id")Integer id){
        return pbRepository.findById(id).get();
    }
    //查询回复
    @PostMapping("/{id}/tie/findreplys")
    public List<replys> replysList(@PathVariable("id")Integer id){
        return pbRepository.findById(id).get().getReplysList();
    }
    //发帖
    @UserLoginToken
    @RequestMapping("/post")
    public Object addpost(HttpServletRequest httpServletRequest,@RequestParam("FN")String content){
        JSONObject jsonObject=new JSONObject();
        String token= httpServletRequest.getHeader("token");
        String userid= JWT.decode(token).getAudience().get(0);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date(System.currentTimeMillis());
        String time=formatter.format(date);
        try {
            pbRepository.addpost(userid, content, time);

            jsonObject.put("message", "发帖成功！");
        }catch (Exception e) {
            jsonObject.put("message", "发帖失败！");
        }
        return jsonObject;
    }
    //回复
    @UserLoginToken
    @RequestMapping("/{id}/tie/reply")
    public Object addreply(HttpServletRequest httpServletRequest,@PathVariable("id")Integer tid,@RequestParam("PN")String content){
        JSONObject jsonObject=new JSONObject();
        String token= httpServletRequest.getHeader("token");
        String userid= JWT.decode(token).getAudience().get(0);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date(System.currentTimeMillis());
        String time=formatter.format(date);
        try{
            replyRepository.addreply(userid,content,time,tid);
            jsonObject.put("message", "回复成功！");
        }catch (Exception e){
            jsonObject.put("message", "回复失败！");
        }
        return jsonObject;
    }
}
