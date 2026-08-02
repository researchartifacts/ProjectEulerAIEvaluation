package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ901toQ1000;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ943 {

    @Autowired
    private GPT54MiniQ901toQ1000 batchService;

    public ResponseDto Question943() {
        return batchService.Question943();
    }
}
