package com.eightrookies.yantu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ReplyRepository extends JpaRepository<replys,Integer> {
    @Modifying
    @Query(nativeQuery = true,value = "insert into RES(USERNAME,PN,RTIME,TID) values (?1,?2,?3,?4)")
    public void addreply(String name,String content,String time,Integer tid);

}
