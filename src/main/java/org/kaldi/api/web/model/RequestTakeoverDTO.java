package org.kaldi.api.web.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RequestTakeoverDTO {

    @NotNull
    private Long messageId;

    @NotEmpty
    private String userDesignation;

    public RequestTakeoverDTO() {}

    public RequestTakeoverDTO(Long messageId, String userDesignation) {
        this.messageId = messageId;
        this.userDesignation = userDesignation;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getUserDesignation() {
        return userDesignation;
    }

    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }
}
