package me.obelmokhtar.usecaseormpatientrdv.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME", unique = true, length = 30)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // ne pas serialiser le password lors de la lecture
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES")
    private List<Role> roles = new ArrayList<>();
}
