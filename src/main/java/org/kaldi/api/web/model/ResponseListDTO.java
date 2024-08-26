package org.kaldi.api.web.model;

import org.kaldi.api.AbstractResponse;
import org.kaldi.model.Message;

import java.util.List;

public class ResponseListDTO extends AbstractResponse {

    private List<Message> filteredMessages;

    public List<Message> getFilteredMessages() {
        return filteredMessages;
    }

    public void setFilteredMessages(List<Message> filteredMessages) {
        this.filteredMessages = filteredMessages;
    }
}
