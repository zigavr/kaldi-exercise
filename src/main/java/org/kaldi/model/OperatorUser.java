package org.kaldi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class OperatorUser extends PanacheEntity {

    private String designation;
    private String username;
    private String password;

}
