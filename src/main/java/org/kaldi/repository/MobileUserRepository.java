package org.kaldi.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kaldi.model.MobileUser;

@ApplicationScoped
public class MobileUserRepository implements PanacheRepository<MobileUser> {

    public MobileUser findByDesignation(String designation) {
        return find("designation", designation).singleResult();
    }
}
