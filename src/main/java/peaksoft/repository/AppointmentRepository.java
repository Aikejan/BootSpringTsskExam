package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Appointment;

public interface AppointmentRepository extends JpaRepository <Appointment,Long> {
}
