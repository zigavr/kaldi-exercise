package org.kaldi;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.kaldi.model.Person;
import org.kaldi.repository.PersonRepository;

import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> list() {
        return personRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Person person) {
        personRepository.persist(person);
    }
}
