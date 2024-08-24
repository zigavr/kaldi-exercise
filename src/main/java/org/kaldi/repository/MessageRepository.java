package org.kaldi.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kaldi.model.Message;

@ApplicationScoped
public class MessageRepository implements PanacheRepository<Message> {
}
