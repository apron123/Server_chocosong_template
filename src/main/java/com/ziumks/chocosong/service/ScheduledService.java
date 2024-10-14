package com.ziumks.chocosong.service;

import com.ziumks.chocosong.model.dto.common.WidgetEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 스케쥴러 서비스 로직 - Start Point
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@RequiredArgsConstructor
@Service("scheduledService")
public class ScheduledService {

    private final AService aService;

    private final BService bService;

    private final WidgetEventDto widgetEventDto;

    @Scheduled(cron = "0 * * * * *")
    public void schedule() {
        log.info(widgetEventDto.toString());
        log.info("schedule start123456788 ..");
    }

    public void methodA() {
        aService.MethodA();
    }

    @Async
    public void methodB() {
        bService.MethodB();
    }

}
