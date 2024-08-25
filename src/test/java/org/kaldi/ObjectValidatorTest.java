package org.kaldi;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kaldi.api.web.model.RequestReplyDTO;
import org.kaldi.api.mobile.model.RequestMessageDTO;
import org.kaldi.api.web.model.RequestTakeoverDTO;
import org.kaldi.model.MobileUser;

import java.util.stream.Collectors;

public class ObjectValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        HibernateValidatorConfiguration configuration = (HibernateValidatorConfiguration) Validation.byDefaultProvider().configure();
        configuration.messageInterpolator(new ParameterMessageInterpolator());
        ValidatorFactory factory = configuration.buildValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    public void mobileUserMissingEverything() {
        MobileUser mobileUser = new MobileUser();
        System.out.println(validator.validate(mobileUser).stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("; ")));
    }

    @Test
    public void messageDTOMissingEverything() {
        RequestMessageDTO messageDTO = new RequestMessageDTO();
        System.out.println(validator.validate(messageDTO));
    }

    @Test
    public void requestAnswerDTOMissingEverything() {
        RequestReplyDTO messageDTO = new RequestReplyDTO();
        System.out.println(validator.validate(messageDTO));
    }

    @Test
    public void requestTakeoverDTOMissingEverything() {
        RequestTakeoverDTO messageDTO = new RequestTakeoverDTO();
        System.out.println(validator.validate(messageDTO));
    }
}
