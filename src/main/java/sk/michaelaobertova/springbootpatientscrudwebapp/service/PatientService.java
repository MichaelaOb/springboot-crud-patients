package sk.michaelaobertova.springbootpatientscrudwebapp.service;

import sk.michaelaobertova.springbootpatientscrudwebapp.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatients();
    public void addPatient(Patient patient);
    Patient getPatientById(long id);
    public void deleteById(long id);
}
