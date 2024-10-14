package com.ziumks.chocosong.model.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * SystemMonitoring DTO
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SystemMonitoringDto {

    @Builder.Default
    private String tableNm = "system_monitoring";

    @Builder.Default
    private String pkNm = "base_table_name";

    private String baseTableName;

    private String baseSchemaName;

    private int crawlerStatus;

    private int saveStatus;

    private int elasticStatus;

    private String systemName;

    private LocalDateTime dataTime;

    private String msg;

    private String tableDescription;

    private String dataStatus;

    private LocalDateTime collectorTime;

    private String collectorStatus;

}
