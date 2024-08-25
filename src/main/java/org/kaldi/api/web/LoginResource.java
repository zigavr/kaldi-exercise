package org.kaldi.api.web;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.kaldi.api.dao.WebUserDao;
import org.kaldi.api.web.model.RequestLoginDTO;
import org.kaldi.api.web.model.ResponseLoginDTO;
import org.kaldi.api.web.model.ResponseReplyDTO;
import org.kaldi.helper.ObjectValidatorHelper;
import org.kaldi.helper.ResponseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/login")
public class LoginResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebMessageResource.class);

    @Inject
    private WebUserDao webUserDao;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response login(RequestLoginDTO requestLoginDTO) {
        Response response;
        ResponseLoginDTO responseLoginDTO = new ResponseLoginDTO();

        String isValid = ObjectValidatorHelper.isValid(requestLoginDTO);
        if (isValid == null || isValid.isEmpty()) {
            if (webUserDao.findByUsernameAndPassword(requestLoginDTO)) {
                response = Response.ok("Login successful").build();
            } else {
                response = Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
            LOGGER.info("Validation of answer failed. {}", isValid);
            ResponseHelper.setError(responseLoginDTO, isValid);
            response = Response.status(Response.Status.BAD_REQUEST).entity(responseLoginDTO).build();
        }

        return response;
    }
}
