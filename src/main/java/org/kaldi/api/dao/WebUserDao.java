package org.kaldi.api.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.kaldi.api.web.model.RequestLoginDTO;
import org.kaldi.model.WebUser;
import org.kaldi.repository.WebUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ApplicationScoped
public class WebUserDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(MobileUserDao.class);

    @Inject
    private WebUserRepository webUserRepository;

    public boolean findByUsernameAndPassword(RequestLoginDTO requestLoginDTO) {
        return webUserRepository.findByUsernameAndPassword(requestLoginDTO.getUsername(), requestLoginDTO.getPassword());
    }

    public WebUser findByDesignation(String webUserDesignation) {
        WebUser result = null;

        Optional<WebUser> foundWebUser = webUserRepository.findByDesignation(webUserDesignation);
        if (foundWebUser.isPresent()) {
            result = foundWebUser.get();
        }

        return result;
    }
}
