package org.kaldi.api.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.kaldi.api.mobile.model.RequestAnswerDTO;
import org.kaldi.api.web.model.RequestReplyDTO;
import org.kaldi.api.mobile.model.RequestMessageDTO;
import org.kaldi.api.web.model.RequestTakeoverDTO;
import org.kaldi.model.Message;
import org.kaldi.model.MobileUser;
import org.kaldi.model.WebUser;
import org.kaldi.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class MessageDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageDao.class);

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private MobileUserDao mobileUserDao;

    @Inject
    private WebUserDao webUserDao;

    public List<Message> findAllMessages() {
        return messageRepository.listAll();
    }

    public Message saveMessage(RequestMessageDTO requestMessageDTO) {
        MobileUser mobileUserDesignation = mobileUserDao.findMobileUser(requestMessageDTO.getMobileUser());

        Message message = new Message();
        message.setQuestion(requestMessageDTO.getQuestion());
        message.setRoom(requestMessageDTO.getRoom());
        message.setMobileUser(mobileUserDesignation);

        messageRepository.persist(message);

        return message;
    }

    public String saveReply(RequestReplyDTO requestAnswerDTO) {
        String error = null;

        Message message = messageRepository.findById(requestAnswerDTO.getMessageId());

        if (message != null) {
            if (message.getWebUser() != null) {
                message.setReply(requestAnswerDTO.getReply());
                messageRepository.persist(message);
            } else {
                LOGGER.info("Message with id {} cannot be answered yet because it hasn't been taken over yet!", requestAnswerDTO.getMessageId());
                error = "Message with id " + + requestAnswerDTO.getMessageId() + " cannot be answered yet because it hasn't been taken over yet!";
            }
        } else {
            LOGGER.info("No message found with id {}", requestAnswerDTO.getMessageId());
            error = "No message found with id " + requestAnswerDTO.getMessageId();
        }

        return error;
    }

    public String saveTakeover(RequestTakeoverDTO requestTakeoverDTO) {
        String error = null;

        Message message = messageRepository.findById(requestTakeoverDTO.getMessageId());
        WebUser webUser = webUserDao.findByDesignation(requestTakeoverDTO.getUserDesignation());
        if (message != null) {
            if (webUser != null) {
                if (message.getWebUser() == null) {
                    message.setWebUser(webUser);
                    messageRepository.persist(message);
                } else {
                    LOGGER.info("Message has already been taken over by {}", message.getWebUser().getDesignation());
                    error = "Message has already been taken over by " + message.getWebUser().getDesignation();
                }
            } else {
                LOGGER.info("No web user found with designation {}", requestTakeoverDTO.getUserDesignation());
                error = "No web user found with designation " + requestTakeoverDTO.getUserDesignation();
            }
        } else {
            LOGGER.info("No message found with id {}", requestTakeoverDTO.getMessageId());
            error = "No message found with id " + requestTakeoverDTO.getMessageId();
        }

        return error;
    }

    public String getAnswer(RequestAnswerDTO requestAnswerDTO) {
        return messageRepository.findById(requestAnswerDTO.getMessageId()).getReply();
    }
}
