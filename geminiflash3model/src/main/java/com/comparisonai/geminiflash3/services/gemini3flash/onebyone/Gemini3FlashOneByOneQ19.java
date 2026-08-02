package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class Gemini3FlashOneByOneQ19 {

    public ResponseDto Question19() {
        ResponseDto responseDto = new ResponseDto();
        int sundays = 0;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (LocalDate.of(year, month, 1).getDayOfWeek() == DayOfWeek.SUNDAY) {
                    sundays++;
                }
            }
        }
        responseDto.setAnswer(sundays);
        return responseDto;
    }
}
