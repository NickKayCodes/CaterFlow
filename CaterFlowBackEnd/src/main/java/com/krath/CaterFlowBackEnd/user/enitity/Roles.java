package com.krath.CaterFlowBackEnd.user.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employee_roles")
@Setter
@Getter
@NoArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    private String roleName;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
    private List<User> users;

    public Roles(String roleName) {
        this.roleName = roleName;
    }

}
