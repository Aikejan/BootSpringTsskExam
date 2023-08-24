package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.entity.Patient;
import peaksoft.repository.PatientRepository;
import peaksoft.service.PatientService;

import java.util.List;

@Service
@Repository
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientService patientService;


    @Override
    public void savePatient(Long hospitalId, Patient patient) {
        patientRepository.save(patient);

    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> getAllPatient(Long id) {

        return patientRepository.findAll();
    }

    @Override
    public void updatePatient(Long id, Patient patient) {
        Patient patient1 = patientService.getPatientById(id);
        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
        patient1.setPhoneNumber(patient.getPhoneNumber());
        patient1.setGender(patient.getGender());
        patient1.setEmail(patient.getEmail());
        patient1.setHospital(patient.getHospital());
        patient1.setAppointments(patient.getAppointments());

    }


    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);

    }

}
