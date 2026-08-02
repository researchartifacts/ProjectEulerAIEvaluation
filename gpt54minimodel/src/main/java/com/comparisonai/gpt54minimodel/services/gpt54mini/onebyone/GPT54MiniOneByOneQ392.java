package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ301toQ400;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ392 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ301toQ400 delegate;

    public GPT54MiniOneByOneQ392(GPT54MiniQ301toQ400 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question392() {
        return delegate.Question392();
    }
}
