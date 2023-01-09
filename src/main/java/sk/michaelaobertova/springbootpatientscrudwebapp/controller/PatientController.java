package sk.michaelaobertova.springbootpatientscrudwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.michaelaobertova.springbootpatientscrudwebapp.model.Patient;
import sk.michaelaobertova.springbootpatientscrudwebapp.service.PatientService;

import java.util.List;

@Controller
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "index";
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "new_patient";
    }

    @PostMapping("/addPatient")
    public String addNewPatient(@ModelAttribute Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/showUpdatePatientForm/{id}")
    public String showUpdatePatientForm(@PathVariable(value = "id") long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "update_patient";
    }

    @GetMapping("/deletePatientById/{id}")
    public String deletePatientById(@PathVariable long id) {
        patientService.deleteById(id);
        return "redirect:/";
    }
}
