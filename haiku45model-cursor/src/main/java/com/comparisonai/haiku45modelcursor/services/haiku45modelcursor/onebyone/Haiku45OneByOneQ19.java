package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.DayOfWeek;

/**
 * Problem 19: Counting Sundays
 */
@Service
public class Haiku45OneByOneQ19 {

    public ResponseDto Question19() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count Sundays that fell on the 1st of the month during 1901-2000
        
        int sundayCount = 0;
        
        // Iterate through each month from Jan 1901 to Dec 2000
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                LocalDate date = LocalDate.of(year, month, 1);
                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    sundayCount++;
                }
            }
        }
        
        Object result = sundayCount;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
