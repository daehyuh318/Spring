package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest //스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional //rollback 해줌
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("aaa");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 이름으로조회() {

        System.out.println(memberService.findOne(2L).get().getName());


        List<String> list = new ArrayList<>();
        for(int i = 0; i < memberService.findAll().size();i++){
            list.add(memberService.findAll().get(i).getName());
        }
        System.out.println(list);
        System.out.println(memberService.findAll());
        System.out.println(memberService.findAll().stream().map(Member::getName).collect(Collectors.toList()));

    }

}