package org.kaldi.helper;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;
import java.util.stream.Collectors;

public class ObjectValidatorHelper {

    public static <T> String isValid(T object) {
        HibernateValidatorConfiguration configuration = (HibernateValidatorConfiguration) Validation.byDefaultProvider().configure();
        configuration.messageInterpolator(new ParameterMessageInterpolator());
        ValidatorFactory factory = configuration.buildValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(object);

        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("; "));
    }
}
