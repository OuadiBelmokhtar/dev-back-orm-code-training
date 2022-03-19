package me.obelmokhtar.usecaseormpatientrdv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    Collection<RendezVous> rendezVousCollection= new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    Collection<Hopital> hopitals =new ArrayList<>();
}
