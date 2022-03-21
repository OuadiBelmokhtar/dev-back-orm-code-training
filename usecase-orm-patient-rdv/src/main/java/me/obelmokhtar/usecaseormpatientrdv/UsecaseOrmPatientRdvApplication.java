package me.obelmokhtar.usecaseormpatientrdv;

import me.obelmokhtar.usecaseormpatientrdv.entities.*;
import me.obelmokhtar.usecaseormpatientrdv.repositories.*;
import me.obelmokhtar.usecaseormpatientrdv.services.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class UsecaseOrmPatientRdvApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RendezVousRepository rdvRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private HopitalRepository hopitalRepository;
    @Autowired
    private HopitalService hopitalService;

    public static void main(String[] args) {
        SpringApplication.run(UsecaseOrmPatientRdvApplication.class, args);
    }


    public void run1(String... args) throws Exception {

    }

    @Override
    public void run(String... args) throws Exception {
        // ###########################   Tester le mapping des associations    #############################

        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        Patient patient3 = new Patient();
        patient1.setNom("ahmed");
        patient1.setEmail("ahmed@gmail.com");
        patient2.setNom("taha");
        patient2.setEmail("taha@gmail.com");
        patient3.setNom("karim");
        patient3.setEmail("karim@gmail.com");

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);

        Stream.of("Imane", "Souad", "Samira").forEach(name -> {

            Medecin medecin = new Medecin();
            medecin.setNom(name);
            medecin.setEmail(name + "@gmail.com");
            medecin.setSpecialite(Math.random() > 0.5 ? "Génico" : "Dentiste");
            medecinRepository.save(medecin);
        });

        RendezVous rendezVous1 = new RendezVous();
        rendezVous1.setDateRdv(new Date());
        rendezVous1.setHeureRdv(new Date());
        rendezVous1.setStatutsRDV(StatusRDV.PENDING);

        Patient p1 = patientRepository.findByNom("taha");
        Medecin m1 = medecinRepository.findById(1L).get();
        rendezVous1.setPatient(p1);
        rendezVous1.setMedecin(m1);
        rdvRepository.save(rendezVous1);

        // TODO: 3/21/22 Noter bien que pr que Hibernate exécute l'insertion automatiquement ds la BD,
        //  il faut charger les enregistrement de la BD+utiliser le constr sans arg+les setters pr initialiser l'objet, non pas le constr d'init

//        Consultation consultation1 = new Consultation(null, new Date(), "rapport1", null);
//        Consultation consultation2 = new Consultation(null, new Date(), "rapport2", null);
//        Consultation consultation3 = new Consultation(null, new Date(), "rapport3", null);
//
//        RendezVous rendezVous1 = new RendezVous(null, new Date(), new Date(), patient3, medecin1, consultation1);
//        RendezVous rendezVous2 = new RendezVous(null, new Date(), new Date(), patient3, medecin1, consultation2);
//        RendezVous rendezVous3 = new RendezVous(null, new Date(), new Date(), patient2, medecin2, consultation3);
//
//        consultation1.setRendezVous(rendezVous1);
//        consultation2.setRendezVous(rendezVous2);
//        consultation3.setRendezVous(rendezVous3);
//
//        rdvRepository.save(rendezVous1);
//        rdvRepository.save(rendezVous2);
//        rdvRepository.save(rendezVous3);

        /*List<RendezVous> rdvs1 = new ArrayList<>();
        rdvs1.add(rendezVous2);
        rdvs1.add(rendezVous3);
        patient2.setRendezVousCollection(rdvs1);
        patientRepository.save(patient2);*/

        // Patient patient4 = patientRepository.findById(3L).get();
        //patientRepository.findById(3L).get().getRendezVousCollection().forEach(System.out::println);
//        List<RendezVous> rendezVousCollection = patient4.getRendezVousCollection();
//        rendezVousCollection.forEach(System.out::println);
// ###########################   Tester l'insertion pr le mapping de _*____*_    #############################
        // add un Medecin à un Hopital
        /*
        Medecin medecin1 = new Medecin();
        Medecin medecin2 = new Medecin();
        Medecin medecin3 = new Medecin();
        medecin1.setNom("Imane");
        medecin1.setEmail("imane@gmail.com");
        medecin1.setSpecialite("Génico");
        medecin2.setNom("Souad");
        medecin2.setEmail("Souad@gmail.com");
        medecin2.setSpecialite("Dentist");
        medecin3.setNom("Samira");
        medecin3.setEmail("Samira@gmail.com");
        medecin3.setSpecialite("Ophtamo");
        medecinRepository.save(medecin1);
        medecinRepository.save(medecin2);
        medecinRepository.save(medecin3);

        Hopital hopital1 = new Hopital();
        hopital1.setAdresse("Rabat");
        hopitalRepository.save(hopital1);
        hopitalService.addMedecinsToHopital(1L);
        */


// ###########################   Tester le mapping de l heritage    #############################
//        Etudiant e1 = new Etudiant("Ahmed", new Date(), 14.5);
//        Etudiant e2 = new Etudiant("Taha", new Date(), 13.0);
//        personneRepository.save(e1);
//        personneRepository.save(e2);
//
//        Enseignant enseignant1=new Enseignant("Karim",new Date(), "Info");
//        Enseignant enseignant2=new Enseignant("Soufiane",new Date(), "Math");
//        personneRepository.save(enseignant1);
//        personneRepository.save(enseignant2);
    }
}
