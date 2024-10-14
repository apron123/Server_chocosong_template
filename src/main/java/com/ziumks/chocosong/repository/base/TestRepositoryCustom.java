package com.ziumks.chocosong.repository.base;

import com.ziumks.chocosong.model.entity.base.SystemMonitoring;

import java.util.List;

/**
 * Query Dsl 메소드 작성
 *
 * @author 이상민
 * @since  2024.05.21 16:30
 */
public interface TestRepositoryCustom {

    List<SystemMonitoring> getSystemMonitoringList();

}
