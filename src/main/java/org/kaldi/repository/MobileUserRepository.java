package org.kaldi.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.kaldi.model.MobileUser;

import java.util.Optional;

@ApplicationScoped
public class MobileUserRepository implements PanacheRepository<MobileUser> {

    @Transactional
    public Optional<MobileUser> findByDesignation(String designation) {
        PanacheQuery<MobileUser> panacheQuery = find("designation", designation);
        return panacheQuery.singleResultOptional();
    }
}
