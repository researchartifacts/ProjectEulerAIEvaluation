package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ222 {

    public ResponseDto Question222() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 222: Shortest pipe to contain 21 balls
        // Pipe internal radius: 50mm
        // Balls radii: 30mm to 50mm (21 balls)
        // Find length in micrometers

        double pipeRadius = 50.0;
        double totalLength = 0.0;

        // For balls stacked in a pipe, use geometry
        // Each ball of radius r in a pipe of radius R
        // The ball touches the pipe walls

        for (int i = 30; i <= 50; i++) {
            double ballRadius = (double) i;

            // Distance traveled along pipe axis when ball of radius r enters pipe
            // depends on the geometry of the sphere and cylinder

            // When sphere of radius r fits in cylinder of radius R:
            // The sphere's center is at distance sqrt(R^2 - r^2) from the axis
            // But for r > R, the sphere doesn't fit!

            if (ballRadius <= pipeRadius) {
                // Ball fits inside pipe
                totalLength += 2.0 * ballRadius;
            } else {
                // Ball is larger than pipe - it's nested/stacked differently
                // The ball touches the pipe along a circle
                // The effective length contribution needs geometric calculation

                // For ball radius > pipe radius:
                // The ball sits in the pipe with specific contact geometry
                double contactAngle = Math.acos(pipeRadius / ballRadius);
                double axialLength = 2.0 * ballRadius * Math.sin(contactAngle);
                totalLength += axialLength;
            }
        }

        // Convert to micrometers (mm to micrometers is *1000)
        long resultInMicrometers = Math.round(totalLength * 1000);

        responseDto.setAnswer(resultInMicrometers);
        return responseDto;
    }
}
