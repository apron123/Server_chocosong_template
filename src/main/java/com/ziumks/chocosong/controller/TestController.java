package com.ziumks.chocosong.controller;

import com.ziumks.chocosong.model.dto.TestDto;
import com.ziumks.chocosong.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/test")
@RestController("testController")
@Tag(name = "Test API ", description = "Test용 Api")
public class TestController {

    private final TestService testService;

    @PostMapping("/post")
    @Operation(summary = "테스트 post common", description = "테스트")
    public boolean testPost(@RequestBody @Parameter(description = "테스트", required = true) @Valid TestDto testDto) {
        return true;
    }

    @GetMapping("{name}")
    @Operation(summary = "테스트 get common", description = "테스트")
    public TestDto testGet(@PathVariable @Parameter(description = "테스트 패스", required = true) String name,
                              @RequestParam @Parameter(description = "테스트 파라미터", required = true) @Valid TestDto testDto)
    {

        testService.testService();

        return testDto;

    }

}
