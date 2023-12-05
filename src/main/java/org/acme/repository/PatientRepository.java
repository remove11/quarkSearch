package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class PatientRepository implements PanacheRepositoryBase<Patient, String> {
    @WithSession
    public Uni<List<Patient>> findAllPatients() {
        return Patient.<Patient>findAll().list();
    }

    @WithSession
    public Uni<Patient> findBySocialNr(String socialNr) {
        return Patient.find("socialNr", socialNr).firstResult();
    }
    @WithSession
    public Uni<Patient> findBySurename(String surename) {
        return Patient.find("surename", surename).firstResult();
    }

}
