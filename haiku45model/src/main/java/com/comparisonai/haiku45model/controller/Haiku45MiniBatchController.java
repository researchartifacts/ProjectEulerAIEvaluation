package com.comparisonai.haiku45model.controller;

import com.comparisonai.haiku45model.dto.ResponseDto;
import com.comparisonai.haiku45model.services.haiku45model.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/api/haikuclaude/batch")
public class Haiku45MiniBatchController {

    private final Object[] services;

    public Haiku45MiniBatchController(
            Haiku45Q1toQ100 s1,
            Haiku45Q101toQ200 s2,
            Haiku45Q201toQ300 s3,
            Haiku45Q301toQ400 s4,
            Haiku45Q401toQ500 s5,
            Haiku45Q501toQ600 s6,
            Haiku45Q601toQ700 s7,
            Haiku45Q701toQ800 s8,
            Haiku45Q801toQ900 s9,
            Haiku45Q901toQ1000 s10) {

        this.services = new Object[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 };
    }

    @GetMapping("/q{number}")
    public ResponseDto getQuestion(@PathVariable int number) {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Question number must be between 1 and 1000");
        }

        // Calculate service index (e.g., Q250 -> (250-1)/100 = Index 2 -> GPT54MiniQ201toQ300)
        int serviceIndex = (number - 1) / 100;
        Object targetService = services[serviceIndex];

        long startTime = System.nanoTime();
        ResponseDto dto;

        try {
            // Construct method name, e.g., "Question250"
            String methodName = "Question" + number;

            // Dynamically invoke the method on the matched service instance
            Method method = targetService.getClass().getMethod(methodName);
            dto = (ResponseDto) method.invoke(targetService);

        } catch (Exception e) {
            throw new RuntimeException("Failed to execute question " + number, e);
        }

        dto.setTime(System.nanoTime() - startTime);
        return dto;
    }
}
