package me.obelmokhtar.usecaseormpatientrdv;

import me.obelmokhtar.usecaseormpatientrdv.entities.Consultation;
import me.obelmokhtar.usecaseormpatientrdv.entities.Medecin;
import me.obelmokhtar.usecaseormpatientrdv.entities.Patient;
import me.obelmokhtar.usecaseormpatientrdv.entities.RendezVous;
import me.obelmokhtar.usecaseormpatientrdv.repositories.PatientRepository;
import me.obelmokhtar.usecaseormpatientrdv.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class UsecaseOrmPatientRdvApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RendezVousRepository rdvRepository;

    public static void main(String[] args) {
        SpringApplication.run(UsecaseOrmPatientRdvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
    public void run1(String... args) throws Exception {

        Patient patient1 = new Patient(null, "ahmed", "ahmed@gmail.com", null);
        Patient patient2 = new Patient(null, "taha", "taha@gmail.com", null);
        Patient patient3 = new Patient(null, "karim", "karim@gmail.com", null);
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);

        Medecin medecin1=new Medecin(null, "Imane", "imane@gmail.com", "Génico", null, null);
        Medecin medecin2=new Medecin(null, "Souad", "souad@gmail.com", "Dentist", null, null);
        Medecin medecin3=new Medecin(null, "Samira", "samira@gmail.com", "Ophtamo", null, null);

        Consultation consultation1=new Consultation(null, new Date(), "rapport1", null);
        Consultation consultation2=new Consultation(null, new Date(), "rapport2", null);
        Consultation consultation3=new Consultation(null, new Date(), "rapport3", null);

        RendezVous rendezVous1 = new RendezVous(null, new Date(), new Date(), patient3, medecin1, consultation1);
        RendezVous rendezVous2 = new RendezVous(null, new Date(), new Date(), patient3, medecin1, consultation2);
        RendezVous rendezVous3 = new RendezVous(null, new Date(), new Date(), patient2, medecin2, consultation3);

        consultation1.setRendezVous(rendezVous1);
        consultation2.setRendezVous(rendezVous2);
        consultation3.setRendezVous(rendezVous3);

        rdvRepository.save(rendezVous1);
        rdvRepository.save(rendezVous2);
        rdvRepository.save(rendezVous3);

        /*List<RendezVous> rdvs1 = new ArrayList<>();
        rdvs1.add(rendezVous2);
        rdvs1.add(rendezVous3);
        patient2.setRendezVousCollection(rdvs1);
        patientRepository.save(patient2);*/

        Patient patient4 = patientRepository.findById(3L).get();
        //patientRepository.findById(3L).get().getRendezVousCollection().forEach(System.out::println);
//        List<RendezVous> rendezVousCollection = patient4.getRendezVousCollection();
//        rendezVousCollection.forEach(System.out::println);


    }
}
