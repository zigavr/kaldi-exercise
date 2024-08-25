package org.kaldi.api.web;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.kaldi.api.dao.MessageDao;
import org.kaldi.api.web.model.RequestReplyDTO;
import org.kaldi.api.web.model.RequestTakeoverDTO;
import org.kaldi.api.web.model.ResponseReplyDTO;
import org.kaldi.api.web.model.ResponseTakeoverDTO;
import org.kaldi.helper.ObjectValidatorHelper;
import org.kaldi.helper.ResponseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/web/message")
public class WebMessageResource {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebMessageResource.class);

    @Inject
    private MessageDao messageDao;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(messageDao.findAllMessages()).build();
    }

    @PUT
    @Path("/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response answer(RequestReplyDTO requestAnswerDTO) {
        Response response;
        ResponseReplyDTO responseReplyDTO = new ResponseReplyDTO();

        String isValid = ObjectValidatorHelper.isValid(requestAnswerDTO);
        if (isValid == null || isValid.isEmpty()) {
            String error = messageDao.saveReply(requestAnswerDTO);
            if (error != null) {
                ResponseHelper.setError(responseReplyDTO, error);
                response = Response.status(Response.Status.BAD_REQUEST).entity(responseReplyDTO).build();
            } else {
                responseReplyDTO.setError(false);
                response = Response.ok().entity(responseReplyDTO).build();
            }
        } else {
            LOGGER.info("Validation of answer failed. {}", isValid);
            ResponseHelper.setError(responseReplyDTO, isValid);
            response = Response.status(Response.Status.BAD_REQUEST).entity(responseReplyDTO).build();
        }

        return response;
    }

    @PUT
    @Path("/takeover")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response takeover(RequestTakeoverDTO takeoverDTO) {
        Response response;
        ResponseTakeoverDTO responseTakeoverDTO = new ResponseTakeoverDTO();

        String isValid = ObjectValidatorHelper.isValid(takeoverDTO);
        if (isValid == null || isValid.isEmpty()) {
            String error = messageDao.saveTakeover(takeoverDTO);
            if (error != null) {
                ResponseHelper.setError(responseTakeoverDTO, error);
                response = Response.status(Response.Status.BAD_REQUEST).entity(responseTakeoverDTO).build();
            } else {
                responseTakeoverDTO.setError(false);
                response = Response.ok().entity(responseTakeoverDTO).build();
            }
        } else {
            LOGGER.info("Validation of take over failed. {}", isValid);
            ResponseHelper.setError(responseTakeoverDTO, isValid);
            response = Response.status(Response.Status.BAD_REQUEST).entity(responseTakeoverDTO).build();
        }


        return response;
    }
}
