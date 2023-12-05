package org.acme;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient extends Person {
    @Column(name = "created_at")

    private LocalDateTime createdAt;

    public Patient(String surename, String lastname, String keycloakId, String address, String userCredential, String socialNr, String phoneNr, Gender gender, LocalDateTime createdAt) {
        super(surename, lastname, keycloakId, address, socialNr, phoneNr, gender);
        this.createdAt = createdAt;
    }

    public Patient() {
        super();
    }
}