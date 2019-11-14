package com.eightrookies.yantu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PostbarController {
    @Autowired
    PbRepository pbRepository;

    @GetMapping("/tie")
    public List<postbar> postbars(){
        return pbRepository.findAll();
    }

    @PostMapping("/{id}/tie")
    public postbar pb(@PathVariable("id")Integer id){
        return pbRepository.findById(id).get();
    }

    @PostMapping("/{id}/tie/reply")
    public List<replys> replysList(@PathVariable("id")Integer id){
        return pbRepository.findById(id).get().getReplysList();
    }
}
