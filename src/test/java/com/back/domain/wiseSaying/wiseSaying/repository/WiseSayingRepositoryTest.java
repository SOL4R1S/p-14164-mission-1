package com.back.domain.wiseSaying.wiseSaying.repository;

import com.back.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class WiseSayingRepositoryTest {
    @Autowired
    private WiseSayingRepository wiseSayingRepository;

    @Test
    @DisplayName("findQById")
    public void t1() {
         WiseSaying wiseSaying = wiseSayingRepository.findQById(1).orElseThrow();

         assertThat(wiseSaying.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("qCount")
    public void t2() {
        Long count =  wiseSayingRepository.qCount();
        assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("findQAll")
    public void t3() {
        List<WiseSaying> all = wiseSayingRepository.findQAll();
        assertThat(all).hasSize(5);

    }
}