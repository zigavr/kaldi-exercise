package org.kaldi.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kaldi.model.Person;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
