package com.ziumks.chocosong.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 스케쥴러 서비스 로직 - Start Point
 *
 * @author  김주현
 * @since   2024.05.21 16:30
 */
@Slf4j
@Service("aService")
public class AService {
    public void MethodA(){
        log.info("Service A method A start : {}");
    }

}
