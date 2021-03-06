package me.obelmokhtar.usecaseormpatientrdv.repositories;

import me.obelmokhtar.usecaseormpatientrdv.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
