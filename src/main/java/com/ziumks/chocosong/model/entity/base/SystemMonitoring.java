package com.ziumks.chocosong.model.entity.base;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DB와 연동되는 엔티티 객체
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "system_monitoring")
public class SystemMonitoring implements Serializable  {

    @Id
    @Column(name = "base_table_name", length = 64)
    private String baseTableName;

    @Column(name = "base_schema_name", length = 50, nullable = false)
    private String baseSchemaName;

    @Column(name = "crawler_status", nullable = false)
    private int crawlerStatus;

    @Column(name = "save_status", nullable = false)
    private int saveStatus;

    @Column(name = "elastic_status", nullable = false)
    private int elasticStatus;

    @Column(name = "system_name", length = 100)
    private String systemName;

    @Column(name = "data_time")
    private LocalDateTime dataTime;

    @Column(name = "msg", length = 500)
    private String msg;

    @Column(name = "table_description", length = 100)
    private String tableDescription;

    @Column(name = "data_status", length = 5)
    private String dataStatus;

    @Column(name = "collector_time")
    private LocalDateTime collectorTime;

    @Column(name = "collector_status", length = 5)
    private String collectorStatus;

}
