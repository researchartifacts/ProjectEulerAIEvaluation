package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import com.comparisonai.gpt54minimodel.services.gpt54mini.GPT54MiniQ101toQ200;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ198 extends GPT54MiniOneByOneBase {

    private final GPT54MiniQ101toQ200 delegate;

    public GPT54MiniOneByOneQ198(GPT54MiniQ101toQ200 delegate) {
        this.delegate = delegate;
    }

    public ResponseDto Question198() {
        return delegate.Question198();
    }
}