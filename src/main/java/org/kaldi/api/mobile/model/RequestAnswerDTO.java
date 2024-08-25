package org.kaldi.api.mobile.model;

import jakarta.validation.constraints.NotNull;

public class RequestAnswerDTO {

    @NotNull (message = "Missing message id!")
    private Long messageId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
