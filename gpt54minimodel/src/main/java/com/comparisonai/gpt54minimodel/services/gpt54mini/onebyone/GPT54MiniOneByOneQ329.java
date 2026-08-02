package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ301toQ400;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ329 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ301toQ400 delegate;

    public GPT54MiniOneByOneQ329(GPT54MiniQ301toQ400 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question329() {
        return delegate.Question329();
    }
}
