package com.eightrookies.yantu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Transactional
public interface accountRepository extends JpaRepository<users, String> {

    public users findByTel(String phone);
    @Modifying
    @Query(nativeQuery = true,value = "insert into USERS(TEL,PW,NAME,MAJOR,YEARS) values (?1,?2,?3,?4,?5)")
    void adduser(String phone,String pw,String name,Integer major,Integer years);

}
