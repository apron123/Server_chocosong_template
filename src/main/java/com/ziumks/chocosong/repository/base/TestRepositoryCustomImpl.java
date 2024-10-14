package com.ziumks.chocosong.repository.base;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ziumks.chocosong.model.entity.base.QSystemMonitoring;
import com.ziumks.chocosong.model.entity.base.SystemMonitoring;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Query Dsl Override 매서드 작성
 * QEntity 서치 에러시, mvn clean compile 할 것
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
public class TestRepositoryCustomImpl implements TestRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SystemMonitoring> getSystemMonitoringList() {
        return queryFactory
                .selectFrom(QSystemMonitoring.systemMonitoring)
                .fetch();
    }

}
