package me.obelmokhtar.usecaseormpatientrdv.web;

import me.obelmokhtar.usecaseormpatientrdv.entities.Patient;
import me.obelmokhtar.usecaseormpatientrdv.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
}
