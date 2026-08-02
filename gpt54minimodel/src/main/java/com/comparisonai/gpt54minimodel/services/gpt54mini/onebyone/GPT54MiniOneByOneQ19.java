package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ19 extends GPT54MiniOneByOneBase {

    public ResponseDto Question19() {
        ResponseDto responseDto = new ResponseDto();
        int sundays = 0;
        int dayOfWeek = 1; // 1 Jan 1900 was a Monday
        for (int year = 1900; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (year >= 1901 && dayOfWeek == 0) sundays++;
                dayOfWeek = (dayOfWeek + daysInMonth(month, year)) % 7;
            }
        }
        responseDto.setAnswer(String.valueOf(sundays));
        return responseDto;
    }

}
