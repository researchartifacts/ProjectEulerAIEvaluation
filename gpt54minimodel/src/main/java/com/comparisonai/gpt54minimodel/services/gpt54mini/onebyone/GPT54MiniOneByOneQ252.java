package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ201toQ300;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ252 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ201toQ300 delegate;

    public GPT54MiniOneByOneQ252(GPT54MiniQ201toQ300 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question252() {
        return delegate.Question252();
    }
}
