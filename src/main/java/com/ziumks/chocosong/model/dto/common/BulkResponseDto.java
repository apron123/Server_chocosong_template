package com.ziumks.chocosong.model.dto.common;

import lombok.*;

/**
 * Bulk 서버 response dto
 *
 * @author  김주현
 * @since   2024.05.21 16:30
 */
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BulkResponseDto {

    private int responseCode;

    private String tableName;

    private String indexName;

    private String msg;

}
