package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ978 {

    public ResponseDto Question978() {
        ResponseDto responseDto = new ResponseDto();
        int T = 50;

        // Random walk X_t:
        // X_0 = 0
        // X_1 = 1
        // X_t = X_{t-1} +/- |X_{t-2}| with prob 1/2 each.
        // We need Skew(X_50) = E[((X - mu)/sigma)^3] = (E[X^3] - 3*mu*E[X^2] + 2*mu^3) / sigma^3.
        // sigma = sqrt(E[X^2] - mu^2).
        
        // Let e1(t) = E[X_t], e2(t) = E[X_t^2], e3(t) = E[X_t^3].
        // X_t = X_{t-1} + J_t, where J_t is +/- |X_{t-2}| with prob 1/2.
        // E[J_t | X_{t-2}] = 0.
        // E[J_t^2 | X_{t-2}] = |X_{t-2}|^2 = X_{t-2}^2.
        // E[J_t^3 | X_{t-2}] = 0.

        // e1(t) = E[X_{t-1} + J_t] = E[X_{t-1}] + E[E[J_t | X_{t-2}]] = e1(t-1).
        // So e1(t) = e1(1) = 1 for all t >= 1.
        
        // e2(t) = E[(X_{t-1} + J_t)^2] = E[X_{t-1}^2 + 2*X_{t-1}*J_t + J_t^2]
        // = e2(t-1) + 2*E[X_{t-1}*J_t] + E[J_t^2].
        // E[X_{t-1}*J_t] = E[E[X_{t-1}*J_t | X_{t-1}, X_{t-2}]] = E[X_{t-1} * 0] = 0.
        // E[J_t^2] = E[X_{t-2}^2] = e2(t-2).
        // So e2(t) = e2(t-1) + e2(t-2).
        // This is a Fibonacci-like recurrence for the second moment.
        // e2(0) = 0, e2(1) = 1.
        // e2(2) = e2(1) + e2(0) = 1 + 0 = 1.
        // e2(3) = e2(2) + e2(1) = 1 + 1 = 2.
        // e2(4) = e2(3) + e2(2) = 2 + 1 = 3.
        // e2(5) = 3 + 2 = 5. (Wait, problem says sigma=2 for X_5, mu=1. sigma^2 = 5 - 1^2 = 4. Correct!)
        
        // e3(t) = E[(X_{t-1} + J_t)^3] = E[X_{t-1}^3 + 3*X_{t-1}^2*J_t + 3*X_{t-1}*J_t^2 + J_t^3]
        // = e3(t-1) + 3*E[X_{t-1}^2*J_t] + 3*E[X_{t-1}*J_t^2] + E[J_t^3].
        // E[X_{t-1}^2*J_t] = 0.
        // E[J_t^3] = 0.
        // E[X_{t-1}*J_t^2] = E[X_{t-1} * X_{t-2}^2].
        // This requires the joint moment E[X_{t-1} * X_{t-2}^2].
        // Let m(t, k) = E[X_t * X_{t-k}^2]. We need m(t-1, 1).
        // m(t, 1) = E[X_t * X_{t-1}^2] = E[(X_{t-1} + J_t) * X_{t-1}^2] = E[X_{t-1}^3] + E[J_t * X_{t-1}^2] = e3(t-1).
        // So E[X_{t-1} * J_t^2] = E[X_{t-1} * X_{t-2}^2] = e3(t-2).
        // Then e3(t) = e3(t-1) + 3 * e3(t-2).
        // e3(0) = 0, e3(1) = 1.
        // e3(2) = e3(1) + 3*e3(0) = 1 + 0 = 1.
        // e3(3) = e3(2) + 3*e3(1) = 1 + 3 = 4.
        // e3(4) = e3(3) + 3*e3(2) = 4 + 3 = 7.
        // e3(5) = e3(4) + 3*e3(3) = 7 + 12 = 19.
        // Skew(X_5) = (19 - 3*1*5 + 2*1^3) / 2^3 = (19 - 15 + 2) / 8 = 6 / 8 = 0.75. (Correct!)
        
        double[] e1 = new double[T + 1];
        double[] e2 = new double[T + 1];
        double[] e3 = new double[T + 1];
        
        e1[0] = 0; e1[1] = 1;
        e2[0] = 0; e2[1] = 1;
        e3[0] = 0; e3[1] = 1;
        
        for (int t = 2; t <= T; t++) {
            e1[t] = 1;
            e2[t] = e2[t-1] + e2[t-2];
            e3[t] = e3[t-1] + 3 * e3[t-2];
        }
        
        double mu = e1[T];
        double sigma = Math.sqrt(e2[T] - mu * mu);
        double skew = (e3[T] - 3 * mu * e2[T] + 2 * mu * mu * mu) / (sigma * sigma * sigma);
        
        responseDto.setAnswer(String.format("%.8f", skew));
        return responseDto;
    }
}
