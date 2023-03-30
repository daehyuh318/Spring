package com.example.demo;


import com.example.demo.repository.JDBCMemberRepository;
import com.example.demo.repository.JDBCTemplateMemberRepository;
import com.example.demo.repository.JPAMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JDBCMemberRepository(dataSource);
//        return new JDBCTemplateMemberRepository(dataSource);
        return new JPAMemberRepository(em);
    }
}
