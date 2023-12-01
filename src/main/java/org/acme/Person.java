package org.acme;
import io.smallrye.mutiny.Uni;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.vertx.core.eventbus.Message;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Person extends PanacheEntity {

    public enum Gender {
        MAN, WOMAN, OTHER;
    }

    @Column(name = "surename")
    private String surename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "keycloakId")
    private String keycloakId;

    @Column(name = "address")
    private String address;

    @Column(name = "id", unique = true)
    private String userCredential;

    @Id
    @Column(name = "socialNr")
    private String socialNr;

    @Column(name = "phoneNr")
    private String phoneNr;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

}