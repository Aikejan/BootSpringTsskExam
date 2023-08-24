package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
