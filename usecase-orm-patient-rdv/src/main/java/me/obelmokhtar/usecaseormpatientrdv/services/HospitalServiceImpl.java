package me.obelmokhtar.usecaseormpatientrdv.services;

import me.obelmokhtar.usecaseormpatientrdv.entities.Consultation;
import me.obelmokhtar.usecaseormpatientrdv.entities.Medecin;
import me.obelmokhtar.usecaseormpatientrdv.entities.Patient;
import me.obelmokhtar.usecaseormpatientrdv.entities.RendezVous;
import me.obelmokhtar.usecaseormpatientrdv.repositories.ConsultationRepository;
import me.obelmokhtar.usecaseormpatientrdv.repositories.MedecinRepository;
import me.obelmokhtar.usecaseormpatientrdv.repositories.PatientRepository;
import me.obelmokhtar.usecaseormpatientrdv.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public List<RendezVous> findAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).get();
    }

}
