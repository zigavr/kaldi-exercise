package org.kaldi.api.mobile.model;

import org.kaldi.api.AbstractResponse;
import org.kaldi.model.Message;

public class ResponseAnswerDTO extends AbstractResponse {

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
