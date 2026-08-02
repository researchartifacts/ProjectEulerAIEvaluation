package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ90 extends GPT54MiniOneByOneBase {

    public ResponseDto Question90() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setAnswer("1217");
        return responseDto;
    }

}
