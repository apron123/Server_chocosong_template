package com.ziumks.chocosong.model.dto.common;

import lombok.*;

/**
 * 공통 response dto
 *
 * @author  김주현
 * @since   2024.05.21 16:30
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto {

    private int resultCode;

    private Object resultData;

    private String resultMsg;

    private String resultFlag;

}
