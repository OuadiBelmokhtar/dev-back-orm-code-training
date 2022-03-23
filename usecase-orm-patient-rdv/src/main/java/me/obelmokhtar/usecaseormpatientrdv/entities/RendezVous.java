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
public class RendezVous {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // on veut utiliser UUID.randomUUID().toString() pr generer l id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date dateRdv;
    @Temporal(TemporalType.TIME)
    private Date heureRdv;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private StatusRDV statutsRDV;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous", fetch = FetchType.EAGER)
    private Consultation consultation;
}
