package me.obelmokhtar.usecaseormpatientrdv.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Date dateConsultation;
    private String rapport;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// eviter la serialisation en mode lecture
    @OneToOne(fetch = FetchType.EAGER)
    private RendezVous rendezVous;

}
