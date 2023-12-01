package org.acme;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Employee extends Person {

    @Column(name = "employeeId", unique = true)
    private String employeeId;

    @OneToMany(mappedBy = "createdBy")
    private Uni<List<Encounter>> createdEncounters;

    // Constructors...
}