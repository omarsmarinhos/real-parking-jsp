package com.RealParking.persitence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "descripcion")
    private String description;
    @Column(name = "estado")
    private String state;

    public Role() {
    }

    public Role(Integer idRol, String description, String state) {
        this.idRol = idRol;
        this.description = description;
        this.state = state;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRol=" + idRol +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
