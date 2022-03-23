package me.obelmokhtar.usecaseormpatientrdv.repositories;

import me.obelmokhtar.usecaseormpatientrdv.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
