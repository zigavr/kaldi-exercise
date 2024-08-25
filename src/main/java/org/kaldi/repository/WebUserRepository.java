package org.kaldi.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.kaldi.model.MobileUser;
import org.kaldi.model.WebUser;

import java.util.Optional;

@ApplicationScoped
public class WebUserRepository implements PanacheRepository<WebUser> {

    public Optional<WebUser> findByDesignation(String designation) {
        PanacheQuery<WebUser> panacheQuery = find("designation", designation);
        return panacheQuery.singleResultOptional();
    }

    public boolean findByUsernameAndPassword(String username, String password) {
        return find("username = ?1 and password = ?2", username, password).firstResultOptional().isPresent();
    }

}
