package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ301toQ400;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ338 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ301toQ400 delegate;

    public GPT54MiniOneByOneQ338(GPT54MiniQ301toQ400 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question338() {
        return delegate.Question338();
    }
}
