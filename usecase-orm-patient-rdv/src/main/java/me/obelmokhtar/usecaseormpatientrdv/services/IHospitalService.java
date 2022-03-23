package me.obelmokhtar.usecaseormpatientrdv.services;

import me.obelmokhtar.usecaseormpatientrdv.entities.Consultation;
import me.obelmokhtar.usecaseormpatientrdv.entities.Medecin;
import me.obelmokhtar.usecaseormpatientrdv.entities.Patient;
import me.obelmokhtar.usecaseormpatientrdv.entities.RendezVous;

import java.util.List;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Medecin findMedecinById(Long id);
    List<RendezVous> findAllRendezVous();
}
