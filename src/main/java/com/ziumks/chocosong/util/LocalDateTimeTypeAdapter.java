package com.ziumks.chocosong.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ziumks.chocosong.config.common.Constants;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeTypeAdapter extends TypeAdapter<LocalDateTime> {

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        if (value != null) {
            out.value(value.format(Constants.DateTimeFormat.COMMON.getFormatter()));
        } else {
            out.nullValue();
        }
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        String str = in.nextString();
        if (str != null) {
            return LocalDateTime.parse(str, Constants.DateTimeFormat.COMMON.getFormatter());
        } else {
            return null;
        }
    }

}
