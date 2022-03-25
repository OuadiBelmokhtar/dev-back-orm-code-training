package me.obelmokhtar.usecaseormpatientrdv.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.obelmokhtar.usecaseormpatientrdv.entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String roleName;
    @Column(name="DESCRIPTION")
    private String desc;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // eviter la serialisation en mode lecture
    @ToString.Exclude // exclure cet attribut de toString() pr empecher les invocations cycliques entre Role et User
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

}
