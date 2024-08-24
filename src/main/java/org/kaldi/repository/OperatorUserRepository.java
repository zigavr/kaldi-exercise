package org.kaldi.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kaldi.model.OperatorUser;

@ApplicationScoped
public class OperatorUserRepository implements PanacheRepository<OperatorUser> {
}
