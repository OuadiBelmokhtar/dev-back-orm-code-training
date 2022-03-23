package me.obelmokhtar.usecaseormpatientrdv.repositories;

import me.obelmokhtar.usecaseormpatientrdv.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
