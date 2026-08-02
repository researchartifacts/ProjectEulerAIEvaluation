package com.comparisonai.gpt54minimodel.controller;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/api/gpt54mini/batch")
public class GPT54MiniBatchController {

    private final Object[] services;

    public GPT54MiniBatchController(
            GPT54MiniQ1toQ100 s1,
            GPT54MiniQ101toQ200 s2,
            GPT54MiniQ201toQ300 s3,
            GPT54MiniQ301toQ400 s4,
            GPT54MiniQ401toQ500 s5,
            GPT54MiniQ501toQ600 s6,
            GPT54MiniQ601toQ700 s7,
            GPT54MiniQ701toQ800 s8,
            GPT54MiniQ801toQ900 s9,
            GPT54MiniQ901toQ1000 s10) {

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
