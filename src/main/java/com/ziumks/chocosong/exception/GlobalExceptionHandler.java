package com.ziumks.chocosong.exception;

import com.ziumks.chocosong.util.CommonMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ChocosongException.class })
    public ResponseEntity<Object> handleChocosongException(
            ChocosongException ex,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", Boolean.FALSE);
        resultMap.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonMethod.gson.toJson(resultMap));

    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", Boolean.FALSE);
        resultMap.put("message", "Internal Server Error");

        return ResponseEntity.status(status)
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonMethod.gson.toJson(resultMap));

    }

}
