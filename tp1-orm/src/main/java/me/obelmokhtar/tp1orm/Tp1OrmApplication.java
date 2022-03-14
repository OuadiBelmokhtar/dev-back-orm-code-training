package me.obelmokhtar.tp1orm;

import me.obelmokhtar.tp1orm.entities.Patient;
import me.obelmokhtar.tp1orm.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp1OrmApplication implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp1OrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // insertion
        System.out.println("\n*** save ***");
        patientRepository.save(new Patient(null, "Ahmed", new Date(), true, 100));
        patientRepository.save(new Patient(null, "Taha", new Date(), false, 200));
        // affichage
        System.out.println("\n*** findAll ***");
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p -> System.out.println(p));
        System.out.println("\n*** findById ***");
        Patient patient= patientRepository.findById(2L).orElse(null);
        System.out.println(patient);
        System.out.println("\n*** save() for update ***");
        patient.setScore(870);
        //patientRepository.save(patient);
        System.out.println("\n*** affichage avec pagination ***");
        expPagination();
        System.out.println("\n*** affichage patients malade via une mtd perso Pageable***");
        Page<Patient> patientPage= patientRepository.findByMalade(true, PageRequest.of(0, 5));
        System.out.println("\n*** affichage patients order by score***");
        List<Patient> patientsByNameLikeScoreAsc = patientRepository.getPatientsByNameLikeScoreAsc(50, "%b%");
        patientsByNameLikeScoreAsc.forEach(System.out::println);

    }

    private void expPagination(){
        patientRepository.deleteAll();
        System.out.println("\n*** insérer 50 patients ***");
        for (int i = 0; i < 50; i++) {
            patientRepository.save(new Patient(null,"Taha", new Date(),Math.random()>0.5?true:false, (int)(Math.random()*100)));
        }
        //
        Page<Patient> pagePatient = patientRepository.findAll(PageRequest.of(0, 5));
        pagePatient.forEach(System.out::println);
        System.out.println("Total pages: "+pagePatient.getTotalPages());
        System.out.println("Total elts: "+pagePatient.getTotalElements());

    }
}
