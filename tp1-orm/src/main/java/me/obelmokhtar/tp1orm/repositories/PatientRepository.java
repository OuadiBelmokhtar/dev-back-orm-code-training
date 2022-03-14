package me.obelmokhtar.tp1orm.repositories;

import me.obelmokhtar.tp1orm.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByMalade(boolean isMalad);

    Page<Patient> findByMalade(boolean isMalad, Pageable pageable);

    List<Patient> findByMaladeAndScoreLessThan(boolean isMalade, int scoreMin);

    List<Patient> findByMaladeIsTrueAndScoreLessThan(int scoreMin);

    List<Patient> findByDateNaissanceBetween(Date d1, Date d2);

    List<Patient> findByScoreAndNomLike(int score, String mc);

    @Query("select p from Patient p where p.score>:p1 and p.nom like :p2 order by p.score asc")
    List<Patient> getPatientsByNameLikeScoreAsc(@Param("p1") int score, @Param("p2") String mc);

}
