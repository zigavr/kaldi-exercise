package org.kaldi.api.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.kaldi.helper.ObjectValidatorHelper;
import org.kaldi.model.MobileUser;
import org.kaldi.repository.MobileUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ApplicationScoped
public class MobileUserDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(MobileUserDao.class);

    @Inject
    private MobileUserRepository mobileUserRepository;

    /**
     * Finds mobile user in database, in case it is missing it validates the object and persists it.
     * @param mobileUser Mobile user
     * @return Mobile user designation
     */
    public MobileUser findMobileUser(MobileUser mobileUser) {
        MobileUser result = null;

        Optional<MobileUser> foundMobileUser = mobileUserRepository.findByDesignation(mobileUser.getDesignation());
        if (foundMobileUser.isPresent()) {
            result = foundMobileUser.get();
        } else {
            boolean isValid = validateMobileUser(mobileUser);
            if (isValid) {
                persistNewMobileUser(mobileUser);
                result = mobileUser;
            }
        }

        return result;
    }

    private boolean validateMobileUser(MobileUser mobileUser) {
        String isValid = ObjectValidatorHelper.isValid(mobileUser);
        if (isValid == null || isValid.isEmpty()) {
            return true;
        } else {
            LOGGER.info("Mobile user is missing information! {}", isValid);
            return false;
        }
    }

    private void persistNewMobileUser(MobileUser mobileUser) {
        mobileUserRepository.persist(mobileUser);
    }
}
