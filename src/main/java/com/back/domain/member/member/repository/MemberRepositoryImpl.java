package com.back.domain.member.member.repository;

import com.back.domain.member.member.entity.Member;
import com.back.domain.member.member.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;


@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Member> findQByUsername(String username) {
        QMember member = QMember.member;
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(member)
                        .where(member.username.eq(username))
                        .fetchOne());
    }

    @Override
    public long qCount() {
        QMember member = QMember.member;
        return Objects.requireNonNullElse(
                queryFactory.select(member.count()).from(member).fetchOne(), 0L);
    }
}
