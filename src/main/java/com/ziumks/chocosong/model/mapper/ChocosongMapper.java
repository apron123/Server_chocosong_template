package com.ziumks.chocosong.model.mapper;

import com.ziumks.chocosong.model.dto.SystemMonitoringDto;
import com.ziumks.chocosong.model.entity.base.SystemMonitoring;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * DTO & Entity 객체간의 매핑하는 객체
 * componentModel="spring"을 통해서 spring container에 Bean으로 등록
 * unmappedTargetPolicy IGNORE 만약, target class에 매핑되지 않는 필드가 있으면, null로 넣게 되고, 따로 report하지 않음
 *
 * @author  이상민
 * @since   2024.06.13 16:30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChocosongMapper {

    /*
    * 시스템모니터링 매핑
    */
    SystemMonitoringDto systemToDto(SystemMonitoring systemMonitoring);
    SystemMonitoring systemToEntity(SystemMonitoringDto systemMonitoringDto);

}
