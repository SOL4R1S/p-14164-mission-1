package com.back.domain.member.member.repository;

import com.back.domain.member.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("findQByUsername")
    public void t1() {
         Member member = memberRepository.findQByUsername("admin").orElseThrow();

         assertThat(member.getUsername()).isEqualTo("admin");
    }

    @Test
    @DisplayName("qCount")
    public void t2() {
        Long count =  memberRepository.qCount();
        assertThat(count).isEqualTo(5);
    }
}