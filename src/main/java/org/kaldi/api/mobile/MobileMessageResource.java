package org.kaldi.api.mobile;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.kaldi.api.mobile.model.RequestAnswerDTO;
import org.kaldi.api.mobile.model.ResponseAnswerDTO;
import org.kaldi.helper.ObjectValidatorHelper;
import org.kaldi.api.dao.MessageDao;
import org.kaldi.api.mobile.model.RequestMessageDTO;
import org.kaldi.api.mobile.model.ResponseMessageDTO;
import org.kaldi.helper.ResponseHelper;
import org.kaldi.model.Message;
import org.kaldi.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/mobile/message")
public class MobileMessageResource {
    private final static Logger LOGGER = LoggerFactory.getLogger(MobileMessageResource.class);

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private MessageDao messageDao;

    @GET
    @Path("/answer")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response answer(RequestAnswerDTO requestAnswerDTO) {
        Response response;
        ResponseAnswerDTO responseAnswerDTO = new ResponseAnswerDTO();

        String isValid = ObjectValidatorHelper.isValid(requestAnswerDTO);
        if (isValid == null || isValid.isEmpty()) {
            responseAnswerDTO.setAnswer(messageDao.getAnswer(requestAnswerDTO));
            responseAnswerDTO.setError(false);

            response = Response.ok().entity(responseAnswerDTO).build();
        } else {
            LOGGER.info("Validation of requesting answer failed. {}", isValid);
            ResponseHelper.setError(responseAnswerDTO, isValid);

            response = Response.status(Response.Status.BAD_REQUEST).entity(responseAnswerDTO).build();
        }

        return response;
    }

    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response send(RequestMessageDTO messageDTO) {
        Response response;
        ResponseMessageDTO responseMessageDTO = new ResponseMessageDTO();

        String isValid = ObjectValidatorHelper.isValid(messageDTO);
        if (isValid == null || isValid.isEmpty()) {
            //After successfully persisting message, we then return the id as response.
            Message message = messageDao.saveMessage(messageDTO);
            messageDTO.setId(String.valueOf(message.id));
            responseMessageDTO.setError(false);
            responseMessageDTO.setRequestMessageDTO(messageDTO);

            response = Response.ok().entity(responseMessageDTO).build();
        } else {
            LOGGER.info("Validation of sending question failed. {}", isValid);
            ResponseHelper.setError(responseMessageDTO, isValid);

            response = Response.status(Response.Status.BAD_REQUEST).entity(responseMessageDTO).build();
        }

        return response;
    }
}
