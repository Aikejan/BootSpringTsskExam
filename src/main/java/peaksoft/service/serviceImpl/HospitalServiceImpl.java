package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.HospitalService;

import java.util.List;


@Service
@Repository
@Transactional
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final HospitalService hospitalService;

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepository.save(hospital);

    }

    @Override
    public Hospital getHospitalById(Long id) {

        return hospitalRepository.findById(id).get();
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital oldHospital = hospitalService.getHospitalById(id);
        oldHospital.setName(hospital.getName());
        oldHospital.setAddress(hospital.getAddress());
        oldHospital.setImage(hospital.getImage());
        hospitalRepository.save(oldHospital);

    }

    @Override
    public void removeHospitalById(Long hospitalId) {
        hospitalRepository.deleteById(hospitalId);

    }
}
