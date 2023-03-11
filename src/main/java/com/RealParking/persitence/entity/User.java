package com.RealParking.persitence.entity;

import jakarta.persistence.*;
import java.io.Serializable;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Role role;

    @Column(name = "url_foto")
    private String url;

    public User() {
    }

    public User(Integer idUser, String username, String password, String fullName, String state, Role role, String url) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.state = state;
        this.role = role;
        this.url = url;
    }

    public User(String username, String password, String fullName, String state, Role role, String url) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.state = state;
        this.role = role;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
                ", url=" + url +
                '}';
    }
}
