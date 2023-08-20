package org.ace.medfilesystem.data.repository;


import org.ace.medfilesystem.data.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

}
