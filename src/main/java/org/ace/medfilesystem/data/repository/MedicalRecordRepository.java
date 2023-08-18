package org.ace.medfilesystem.data.repository;

import com.med.healthrecords.data.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}

