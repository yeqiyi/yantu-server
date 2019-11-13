package com.eightrookies.yantu;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface accountRepository extends JpaRepository<users, String> {

    public users findByTel(String phone);
}
