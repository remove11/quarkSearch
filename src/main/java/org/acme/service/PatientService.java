package org.acme;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.hibernate.reactive.mutiny.Mutiny;

import java.util.List;

@ApplicationScoped
public class PatientService {

    @Inject
    PatientRepository patientRepository;


    public Multi<PatientDTO> findAll() {
        return patientRepository.findAllPatients()
                .onItem().transformToMulti(patients -> Multi.createFrom().iterable(patients))
                .map(p -> convertToDTO(p));
    }

    public Uni<PatientDTO> findBySocialNr(String socialNr) {
        Uni<Patient> p = patientRepository.findBySocialNr(socialNr);
        if(p == null){
            return null;
        }
        return p.map(this::convertToDTO);
    }

    public Uni<PatientDTO> findBySurename(String surename) {
        Uni<Patient> p = patientRepository.findBySurename(surename);
        if(p == null){
            return null;
        }
        return p.map(this::convertToDTO);
    }




    private PatientDTO convertToDTO(Person patient) {
        return new PatientDTO(
                patient.getSocialNr(),
                patient.getSurename(),
                patient.getLastname(),
                patient.getAddress(),
                patient.getPhoneNr(),
                patient.getGender().name(),
                patient.getKeycloakId(),
                null
        );
    }

}

/*

@Inject
    Mutiny.SessionFactory sessionFactory;

    public Uni<PatientDTO> findBySocialNr(String socialNr) {
        System.out.println("Inside service");
        return sessionFactory.withTransaction(tx->Person.<Person>find("socialNr", socialNr).firstResult()
                .map(this::convertToDTO));
    }*/