package com.ziumks.chocosong.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDto {

    @NotBlank(message = "Name not found")
    private String name;

    @NotBlank(message = "Age not found")
    @Size(min = 20, max = 100, message = "Age only between 20 and 100")
    private int age;

}
