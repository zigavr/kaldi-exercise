package org.kaldi.helper;

import org.kaldi.api.AbstractResponse;
import org.kaldi.api.web.WebMessageResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResponseHelper {
    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseHelper.class);

    public static void setError(AbstractResponse response, String failedValidations) {
        response.setError(true);
        response.setMessage(failedValidations);
    }
}
