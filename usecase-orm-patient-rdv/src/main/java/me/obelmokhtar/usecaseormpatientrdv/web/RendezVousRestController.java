package me.obelmokhtar.usecaseormpatientrdv.web;

import me.obelmokhtar.usecaseormpatientrdv.entities.RendezVous;
import me.obelmokhtar.usecaseormpatientrdv.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RendezVousRestController {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @GetMapping("/rdvs")
    List<RendezVous> getAllRendezVous(){
        return rendezVousRepository.findAll();
    }
}
