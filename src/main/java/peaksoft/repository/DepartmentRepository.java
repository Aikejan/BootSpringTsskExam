package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
