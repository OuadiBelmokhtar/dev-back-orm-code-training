package me.obelmokhtar.tp1orm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMP", length = 30)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean malade;
    private int score;
}
