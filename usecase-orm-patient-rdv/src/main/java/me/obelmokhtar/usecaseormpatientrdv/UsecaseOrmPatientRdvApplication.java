package me.obelmokhtar.usecaseormpatientrdv;

import me.obelmokhtar.usecaseormpatientrdv.entities.*;
import me.obelmokhtar.usecaseormpatientrdv.repositories.*;
import me.obelmokhtar.usecaseormpatientrdv.services.IHospitalService;
import me.obelmokhtar.usecaseormpatientrdv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class UsecaseOrmPatientRdvApplication implements CommandLineRunner {

    @Autowired
    IHospitalService hospitalService;
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UsecaseOrmPatientRdvApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // ##########   Tester le mapping des associations @ManyToOne, @OneToOne   ############
        /* scenario:
        1.prendre(enregistrer) un rdv pr un patient et un medecin
        2.enregistrer une consultation pr le rdv pris
        * */

        // set and save Patients
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        Patient patient3 = new Patient();
        patient1.setNom("ahmed");
        patient1.setEmail("ahmed@gmail.com");
        patient2.setNom("taha");
        patient2.setEmail("taha@gmail.com");
        patient3.setNom("karim");
        patient3.setEmail("karim@gmail.com");

        hospitalService.savePatient(patient1);
        hospitalService.savePatient(patient2);
        hospitalService.savePatient(patient3);

        // set and save Medecins
        Stream.of("Imane", "Souad", "Samira").forEach(name -> {
            Medecin medecin = new Medecin();
            medecin.setNom(name);
            medecin.setEmail(name + "@gmail.com");
            medecin.setSpecialite(Math.random() > 0.5 ? "Génico" : "Dentiste");
            hospitalService.saveMedecin(medecin);
        });

        // set and save RendezVous
        RendezVous rendezVous1 = new RendezVous();
        rendezVous1.setId(UUID.randomUUID().toString());
        rendezVous1.setDateRdv(new Date());
        rendezVous1.setHeureRdv(new Date());
        rendezVous1.setStatutsRDV(StatusRDV.PENDING);

        Medecin m1 = hospitalService.findMedecinById(1L);
        rendezVous1.setPatient(patient3);
        rendezVous1.setMedecin(m1);
        hospitalService.saveRendezVous(rendezVous1);

        // set and save Consultation
        RendezVous rendezVous2 = new RendezVous();
        rendezVous2 = hospitalService.findAllRendezVous().get(0);
        Consultation consultation1 = new Consultation();
        consultation1.setDateConsultation(new Date());
        consultation1.setRapport("rapport rdv1 ...");
        consultation1.setRendezVous(rendezVous2);
        hospitalService.saveConsultation(consultation1);

// ##########   Tester l'insertion pr le mapping de l'association @ManyToMany   ############

        // save users
        User user1=new User();
        user1.setUsername("User1");
        user1.setPassword("123");
        userService.addNewUser(user1);
        User user2=new User();
        user2.setUsername("Admin");
        user2.setPassword("123");
        userService.addNewUser(user2);

        // save roles
        Role role1=new Role();
        role1.setRoleName("STAGIAIRE");
        role1.setDesc("role pr les stagiaires");
        userService.addNewRole(role1);
        Role role2=new Role();
        role2.setRoleName("ADMIN");
        role2.setDesc("role pr les admins");
        userService.addNewRole(role2);

        userService.addRoleToUser("Admin","ADMIN");
        userService.addRoleToUser("Admin", "STAGIAIRE");
        userService.addRoleToUser("User1", "STAGIAIRE");

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
