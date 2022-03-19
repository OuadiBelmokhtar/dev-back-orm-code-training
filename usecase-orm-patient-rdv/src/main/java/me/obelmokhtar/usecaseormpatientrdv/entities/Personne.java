package me.obelmokhtar.usecaseormpatientrdv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/* Strategie SINGLE_TABLE
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERS", length = 4) */
/* Strategie JOINED
@Inheritance(strategy = InheritanceType.JOINED)*/
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {
    @Id
    /* Strategie SINGLE_TABLE
    @GeneratedValue(strategy = GenerationType.IDENTITY) */
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    protected String nom;
    protected Date dateNaissance;
}
