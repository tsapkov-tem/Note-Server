package com.example.note.Entity.Users;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Users {
    @Basic
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "role", nullable = false, length = 10)
    private String role;

    public Role getRoleOfSecurity(){
        if ("ADMIN".equals(role)) {
            return Role.ADMIN;
        }
        return Role.USER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return idUser != null && Objects.equals(idUser, users.idUser);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
