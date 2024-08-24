package org.kaldi.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.kaldi.api.model.MessageDTO;
import org.kaldi.model.Message;
import org.kaldi.repository.MessageRepository;
import org.kaldi.repository.MobileUserRepository;

@ApplicationScoped
public class MessageService {

    @Inject
    MessageRepository messageRepository;

    @Inject
    MobileUserRepository mobileUserRepository;

    public Message convertMessageDTO(MessageDTO messageDTO) {
        Message message = new Message();
        message.setQuestion(messageDTO.getQuestion());


        message.setMobileUser();
    }
}
