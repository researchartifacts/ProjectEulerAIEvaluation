package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ101toQ200;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ144 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ101toQ200 delegate;

    public GPT54MiniOneByOneQ144(GPT54MiniQ101toQ200 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question144() {
        return delegate.Question144();
    }
}