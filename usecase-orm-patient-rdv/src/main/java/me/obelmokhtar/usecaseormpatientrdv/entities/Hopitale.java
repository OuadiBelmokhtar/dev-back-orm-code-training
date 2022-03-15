package me.obelmokhtar.usecaseormpatientrdv.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Hopitale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    @ManyToMany(mappedBy = "hopitales")
    private Collection<Medecin> medecins=new ArrayList<>();
}
