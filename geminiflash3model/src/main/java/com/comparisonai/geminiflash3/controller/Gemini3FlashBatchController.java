package com.comparisonai.geminiflash3.controller;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import com.comparisonai.geminiflash3.services.gemini3flash.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/api/gemini3flash/batch")
public class Gemini3FlashBatchController {

    private final Object[] services;

    // Inject all 10 services via constructor
    public Gemini3FlashBatchController(
            Gemini3FlashQ1toQ100 s1,
            Gemini3FlashQ101toQ200 s2,
            Gemini3FlashQ201toQ300 s3,
            Gemini3FlashQ301toQ400 s4,
            Gemini3FlashQ401toQ500 s5,
            Gemini3FlashQ501toQ600 s6,
            Gemini3FlashQ601toQ700 s7,
            Gemini3FlashQ701toQ800 s8,
            Gemini3FlashQ801toQ900 s9,
            Gemini3FlashQ901toQ1000 s10) {

        this.services = new Object[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 };
    }

    @GetMapping("/q{number}")
    public ResponseDto getQuestion(@PathVariable int number) {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Question number must be between 1 and 1000");
        }

        // Calculate service index (e.g., Q105 -> (105-1)/100 = Index 1 -> Gemini3FlashQ101toQ200)
        int serviceIndex = (number - 1) / 100;
        Object targetService = services[serviceIndex];

        long startTime = System.nanoTime();
        ResponseDto dto;

        try {
            // Construct method name, e.g., "Question105"
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
