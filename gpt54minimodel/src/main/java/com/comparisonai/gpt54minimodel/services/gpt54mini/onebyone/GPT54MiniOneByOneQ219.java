package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ201toQ300;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ219 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ201toQ300 delegate;

    public GPT54MiniOneByOneQ219(GPT54MiniQ201toQ300 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question219() {
        return delegate.Question219();
    }
}
