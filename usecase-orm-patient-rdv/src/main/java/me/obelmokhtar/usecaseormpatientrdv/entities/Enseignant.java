package me.obelmokhtar.usecaseormpatientrdv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
/* Strategie SINGLE_TABLE
@DiscriminatorValue(value="PROF") */
public class Enseignant extends Personne {
    private String matiere;

    public Enseignant(String nom, Date dateNaissance,String matiere){
        super(null,nom, dateNaissance);
        this.matiere=matiere;
    }
}
