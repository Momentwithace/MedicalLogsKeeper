package org.ace.medfilesystem.data.repository;


import org.ace.medfilesystem.data.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);
}
