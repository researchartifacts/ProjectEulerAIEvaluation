package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ19 {

    public ResponseDto Question19() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (dayOfWeek(1, month, year) == 0) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int dayOfWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        return (day + (13 * (month + 1)) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
    }
}
