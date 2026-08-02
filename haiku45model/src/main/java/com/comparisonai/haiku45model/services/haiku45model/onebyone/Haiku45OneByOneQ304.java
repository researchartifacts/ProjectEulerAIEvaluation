package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ304 {

    public ResponseDto Question304() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int limit = 100000;
        boolean[] is_prime = new boolean[limit + 1];
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i * i <= limit; i++) {
            if (is_prime[i]) {
                for (int j = i * i; j <= limit; j += i) is_prime[j] = false;
            }
        }
        long prev = 0, curr = 1;
        for (int i = 2; i <= limit; i++) {
            if (is_prime[i]) {
                long next = (prev + curr) % 1000000007L;
                prev = curr;
                curr = next;
            }
        }
        result = curr;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
