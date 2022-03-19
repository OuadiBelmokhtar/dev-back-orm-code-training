package me.obelmokhtar.usecaseormpatientrdv.repositories;

import me.obelmokhtar.usecaseormpatientrdv.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
