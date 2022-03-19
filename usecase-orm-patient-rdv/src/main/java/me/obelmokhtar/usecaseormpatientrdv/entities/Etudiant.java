package me.obelmokhtar.usecaseormpatientrdv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor()
/* Strategie SINGLE_TABLE
@DiscriminatorValue(value = "ETUD")*/
public class Etudiant extends Personne {
    private Double note;

    public Etudiant(String nom, Date dateNaissance, Double note) {
        super(null,nom, dateNaissance);
        this.note = note;
    }
}
