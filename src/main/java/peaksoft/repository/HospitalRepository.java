package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
