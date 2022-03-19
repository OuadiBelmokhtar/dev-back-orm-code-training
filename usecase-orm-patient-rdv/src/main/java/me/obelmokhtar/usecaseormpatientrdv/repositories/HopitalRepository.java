package me.obelmokhtar.usecaseormpatientrdv.repositories;

import me.obelmokhtar.usecaseormpatientrdv.entities.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopitalRepository extends JpaRepository<Hopital, Long> {
}
