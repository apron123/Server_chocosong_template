package com.ziumks.chocosong.model.dto.common;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * widget 이벤트 request dto
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@ToString
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("widget.event")
@Configuration
public class WidgetEventDto {

    //클라이언트 코드
    private String clientCd;
    
    //사이트 코드
    private String siteCd;

    //이벤트 그룹 코드
    private String evetGbCd;

    //통계용
    private String outbMainGb;
    
    //이벤트 발생 시간 - 이것만 현재 시간으로 바꿔주면 됨
    private String outbDtm;

    //이벤트 등급
    private String statEvetCd;
    
    //이벤트 내용
    private String statEvetCntn;

    //발생 이벤트 이름 "저시정 발생"
    private String statEvetNm;

    //이벤트 등급
    private String statEvetGdCd;

    //이벤트 테마 코드
    private String svcThemeCd;

    //이벤트 유닛 서비스 코드
    private String unitSvcCd;

    //이벤트 위도 - x
    private String xCoordinate;

    //이벤트 경도 - y
    private String yCoordinate;

    //이벤트 고도 - z
    private String zCoordinate;

    //위치 코드
    private String znCd;

    //이벤트 장소
    private String outbPlac;

}
