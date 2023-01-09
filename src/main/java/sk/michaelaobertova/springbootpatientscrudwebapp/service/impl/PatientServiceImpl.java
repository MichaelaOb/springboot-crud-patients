package sk.michaelaobertova.springbootpatientscrudwebapp.service.impl;

import org.springframework.stereotype.Service;
import sk.michaelaobertova.springbootpatientscrudwebapp.model.Patient;
import sk.michaelaobertova.springbootpatientscrudwebapp.repository.PatientRepository;
import sk.michaelaobertova.springbootpatientscrudwebapp.service.PatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        Patient patient = null;
        if (optional.isPresent()) {
            patient = optional.get();
        } else {
            throw new RuntimeException(String.format("Patient with id %d id does not exist", id));
        }

        return patient;
    }

    @Override
    public void deleteById(long id) {
        patientRepository.deleteById(id);
    }
}
