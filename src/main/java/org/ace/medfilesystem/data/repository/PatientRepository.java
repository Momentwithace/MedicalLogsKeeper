package org.ace.medfilesystem.data.repository;

import com.med.healthrecords.data.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
