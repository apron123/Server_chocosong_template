package com.ziumks.chocosong.config.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.time.format.DateTimeFormatter;

@UtilityClass
public final class Constants {

    @Getter
    @AllArgsConstructor
    public enum DateTimeFormat {

        COMMON("yyyy-MM-dd HH:mm:ss", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"), "Asia/Seoul"),
        WIDGET("yyyyMMddHHmmssSSS", DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"), "Asia/Seoul");

        private final String format;
        private final DateTimeFormatter formatter;
        private final String timeZone;

    }

}
