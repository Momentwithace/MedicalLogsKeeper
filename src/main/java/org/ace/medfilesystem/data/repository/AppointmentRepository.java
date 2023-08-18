package org.ace.medfilesystem.data.repository;

import com.med.healthrecords.data.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
