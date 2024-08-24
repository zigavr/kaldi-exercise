package org.kaldi.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.kaldi.api.model.MessageDTO;
import org.kaldi.model.Message;
import org.kaldi.repository.MessageRepository;

import java.util.List;

@Path("/message")
public class MessageResource {

    @Inject
    private MessageRepository messageRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> list() {
        return messageRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(MessageDTO message) {
        messageRepository.persist(message);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public void test() {
        Message message = new Message();

    }
}
