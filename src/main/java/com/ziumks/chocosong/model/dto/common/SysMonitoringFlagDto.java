package com.ziumks.chocosong.model.dto.common;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * 시스템 모니터링 status flag dto
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SysMonitoringFlagDto {

    @NotBlank(message = "TableName not found")
    private String tableName;

    @NotBlank(message = "SchemaName not found")
    private String schemaName;

    @Builder.Default
    private int crawlerStatus = 0;

    @Builder.Default
    private int saveStatus = 0;

    @Builder.Default
    private int elasticStatus = 0;

}
