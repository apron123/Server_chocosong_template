package com.ziumks.chocosong.service;


import com.ziumks.chocosong.model.entity.base.SystemMonitoring;
import com.ziumks.chocosong.repository.base.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 서비스 로직
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
@Service("testService")
public class TestService {

    private final TestRepository testRepository;

    public void testService() {
        List<SystemMonitoring> systemMonitoring = testRepository.getSystemMonitoringList();
        log.info("systemMonitoring size : " + systemMonitoring.size());
    }

}