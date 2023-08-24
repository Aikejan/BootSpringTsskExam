package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entity.Department;

import java.util.List;

@Service
public interface DepartmentService {
    void saveDepartment(Long hospitalId, Department department);


    Department getDepartmentById(Long id);


    List<Department> getAllDepartment(Long id);


    void updateDepartment(Long id, Department department);


    void deleteDepartmentById(Long id);

    void assignDoctor(Long doctorId, Long departmentId);


}

