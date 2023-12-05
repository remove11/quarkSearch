package org.acme;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PatientDTO {
    private String socialNr;
    private String surename;
    private String lastname;
    private String address;
    private String phoneNr;
    private String gender;
    private String keycloakId;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "PatientDTO{" +
                "socialNr='" + socialNr + '\'' +
                ", surename='" + surename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", gender='" + gender + '\'' +
                ", keycloakId='" + keycloakId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}