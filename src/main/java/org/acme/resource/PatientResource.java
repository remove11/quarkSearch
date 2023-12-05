package org.acme;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/patient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {

    @Inject
    PatientService patientService;

    @GET
    public Multi<PatientDTO> getAll() {
        return patientService.findAll();
    }
/*
    @GET
    @Path("/{surename}")
    public Uni<PatientDTO> getBySurename(@PathParam("surename") String surename) {
        return patientService.findBySurename(surename);
    }*/

    @GET
    @Path("/socialNr/{social_nr}")
    public Uni<PatientDTO> getBySocialNr(@PathParam("social_nr") String socialNr) {
        return patientService.findBySocialNr(socialNr);
    }

    @GET
    @Path("/surename/{surename}")
    public Uni<PatientDTO> getBySurename(@PathParam("surename") String surename) {
        return patientService.findBySurename(surename);
    }

}