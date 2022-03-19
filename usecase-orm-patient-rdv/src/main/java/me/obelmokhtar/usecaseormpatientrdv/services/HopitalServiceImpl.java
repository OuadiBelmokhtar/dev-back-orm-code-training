package me.obelmokhtar.usecaseormpatientrdv.services;

import me.obelmokhtar.usecaseormpatientrdv.entities.Hopital;
import me.obelmokhtar.usecaseormpatientrdv.entities.Medecin;
import me.obelmokhtar.usecaseormpatientrdv.repositories.HopitalRepository;
import me.obelmokhtar.usecaseormpatientrdv.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Transactional
public class HopitalServiceImpl implements HopitalService {
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private HopitalRepository hopitalRepository;

    @Override
    public void addMedecinsToHopital(Long hopitalId) {
        Medecin m1 = medecinRepository.findById(1L).get();
        Medecin m2 = medecinRepository.findById(2L).get();
        Medecin m3 = medecinRepository.findById(3L).get();

        Hopital h1 = hopitalRepository.findById(hopitalId).get();
        // l'ajout des medecins ds h1 marche ds le code, mais ds la BD non (l insertion ne se fait pas ds la table MEDECIN_HOPITALS!
        h1.getMedecins().add(m1);
        h1.getMedecins().forEach(System.out::println);
    }
}
