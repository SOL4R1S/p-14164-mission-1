package com.back.domain.wiseSaying.wiseSaying.repository;

import com.back.domain.wiseSaying.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepositoryCustom {
    long qCount();

    List<WiseSaying> findQAll();

    Optional<WiseSaying> findQById(int id);
}
