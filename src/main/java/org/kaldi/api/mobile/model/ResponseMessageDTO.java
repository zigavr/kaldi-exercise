package org.kaldi.api.mobile.model;

import org.kaldi.api.AbstractResponse;

public class ResponseMessageDTO extends AbstractResponse {

    private RequestMessageDTO requestMessageDTO;

    public ResponseMessageDTO() {
        super();
    }

    public ResponseMessageDTO(boolean error, String message, RequestMessageDTO productRequest) {
        super(error, message);
        this.requestMessageDTO = productRequest;
    }

    public RequestMessageDTO getRequestMessageDTO() {
        return requestMessageDTO;
    }

    public void setRequestMessageDTO(RequestMessageDTO requestMessageDTO) {
        this.requestMessageDTO = requestMessageDTO;
    }
}
