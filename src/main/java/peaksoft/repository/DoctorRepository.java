package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
