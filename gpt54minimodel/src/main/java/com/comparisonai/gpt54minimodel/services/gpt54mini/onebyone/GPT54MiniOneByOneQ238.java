package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ201toQ300;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ238 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ201toQ300 delegate;

    public GPT54MiniOneByOneQ238(GPT54MiniQ201toQ300 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question238() {
        return delegate.Question238();
    }
}
