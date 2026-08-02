package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ201toQ300;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ256 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ201toQ300 delegate;

    public GPT54MiniOneByOneQ256(GPT54MiniQ201toQ300 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question256() {
        return delegate.Question256();
    }
}
