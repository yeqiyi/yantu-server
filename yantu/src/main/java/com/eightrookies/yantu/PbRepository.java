package com.eightrookies.yantu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface PbRepository extends JpaRepository<postbar,Integer> {
    @Modifying
    @Query(nativeQuery = true,value = "insert into TIE(USERNAME,FN,TDATE) values (?1,?2,?3)")
    public void addpost(String name,String content,String date);
}
