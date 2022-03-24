package me.obelmokhtar.usecaseormpatientrdv.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// eviter la serialisation en mode lecture
    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    Collection<RendezVous> rendezVousCollection= new ArrayList<>();

}
