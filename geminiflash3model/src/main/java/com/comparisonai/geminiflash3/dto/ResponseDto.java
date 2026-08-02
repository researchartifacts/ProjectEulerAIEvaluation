package com.comparisonai.geminiflash3.dto;

public class ResponseDto {

    private Object answer;
    private long time;

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
