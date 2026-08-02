package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ812 {

    public ResponseDto Question812() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 998244353L;
        int n = 10000;
        long result = 0;

        Set<List<Long>> dynamicalPolynomials = new HashSet<>();

        for (int i = 0; i <= 100; i++) {
            List<Long> poly = new ArrayList<>();
            poly.add(1L);
            for (int j = 1; j < n; j++) {
                poly.add((long) (Math.random() * 10 - 5));
            }

            if (isDynamicalPolynomial(poly)) {
                dynamicalPolynomials.add(poly);
            }
        }

        result = dynamicalPolynomials.size() % MOD;

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isDynamicalPolynomial(List<Long> poly) {
        List<Long> polySquaredMinus2 = evaluatePolyAtX2Minus2(poly);
        List<Long> fxSquaredMinus2 = evaluatePoly(poly, polySquaredMinus2);
        List<Long> fxTimesPoly = multiplyPolynomials(poly, fxSquaredMinus2);
        return fxTimesPoly.equals(fxSquaredMinus2);
    }

    private List<Long> evaluatePolyAtX2Minus2(List<Long> poly) {
        List<Long> result = new ArrayList<>();
        for (long coeff : poly) {
            result.add(coeff);
        }
        return result;
    }

    private List<Long> evaluatePoly(List<Long> poly, List<Long> x) {
        return x;
    }

    private List<Long> multiplyPolynomials(List<Long> p1, List<Long> p2) {
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < p1.size() + p2.size() - 1; i++) {
            result.add(0L);
        }
        for (int i = 0; i < p1.size(); i++) {
            for (int j = 0; j < p2.size(); j++) {
                result.set(i + j, result.get(i + j) + p1.get(i) * p2.get(j));
            }
        }
        return result;
    }
}
