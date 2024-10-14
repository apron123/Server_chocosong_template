package com.ziumks.chocosong.config.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;

/**
 * 공통 common 시스템 프로퍼티 값 주입
 *
 * @author  이상민
 * @since   2024.06.04 16:30
 */

@ToString
@Valid
@Getter @Setter
@ConfigurationProperties(prefix = "common.api")
@Configuration("commonApiProperties")
public class CommonApiProperties {

    private Bulk bulk;
    private BaDda baDda;
    private Widget widget;

    // 벌크 서버 관련 설정
    @Getter @Setter
    public static class Bulk { private String url; }

    // 시스템 모니터링 서버 관련 설정
    @Getter @Setter
    public static class BaDda { private String url; }

    // 위젯 서버 관련 설정
    @Getter @Setter
    public static class Widget { private String url; }

}
