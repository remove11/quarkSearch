package org.acme;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "person")
public abstract class Person extends PanacheEntityBase {

    public enum Gender {
        MAN, WOMAN, OTHER;
    }

    @Column(name = "surename")
    private String surename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "keycloak_id")
    private String keycloakId;

    @Column(name = "adress")
    private String address;

    @Id
    @Column(name = "social_nr")
    private String socialNr;

    @Column(name = "phone_nr")
    private String phoneNr;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public Person(String surename, String lastname, String keycloakId, String address, String socialNr, String phoneNr, Gender gender) {
        this.surename = surename;
        this.lastname = lastname;
        this.keycloakId = keycloakId;
        this.address = address;
        this.socialNr = socialNr;
        this.phoneNr = phoneNr;
        this.gender = gender;
    }
    public Person() {

    }

}