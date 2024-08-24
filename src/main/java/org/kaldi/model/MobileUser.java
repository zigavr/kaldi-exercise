package org.kaldi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class MobileUser extends PanacheEntity {

    private String designation;
    private String firstName;
    private String lastName;
}
