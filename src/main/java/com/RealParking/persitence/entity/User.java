package com.RealParking.persitence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {

    public static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUser;

    @Column(name = "usuario")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "nombre_completo")
    private String fullName;

    @Column(name = "estado")
    private String state;


    @OneToOne
    @JoinColumn(name = "id_rol")
    private Role role;

    @Column(name = "foto")
    private Blob photo;

    public User() {
    }

    public User(Integer idUser, String username, String password, String fullName, String state, Role role, Blob photo) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.state = state;
        this.role = role;
        this.photo = photo;
    }

    public User(String username, String password, String fullName, String state, Role role, Blob photo) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.state = state;
        this.role = role;
        this.photo = photo;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", state='" + state + '\'' +
                ", role=" + role +
                ", photo=" + photo +
                '}';
    }
}
