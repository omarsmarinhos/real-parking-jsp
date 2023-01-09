package com.RealParking.persitence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "incidente")
@NamedQueries({
        @NamedQuery(name = "Incident.findAll", query = "SELECT i FROM Incident i")
})
public class Incident implements Serializable {
    public static long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente")
    private Integer idIncident;

    @OneToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    private String dni;

    @Column(name = "nombre_completo")
    private String fullName;

    @Column(name = "fecha")
    private LocalDateTime date;

    public Incident() {
    }

    public Incident(Integer idIncident, Ticket ticket, User user, String dni, String fullName, LocalDateTime date) {
        this.idIncident = idIncident;
        this.ticket = ticket;
        this.user = user;
        this.dni = dni;
        this.fullName = fullName;
        this.date = date;
    }

    public Incident(Ticket ticket, User user, String dni, String fullName, LocalDateTime date) {
        this.ticket = ticket;
        this.user = user;
        this.dni = dni;
        this.fullName = fullName;
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Incident.serialVersionUID = serialVersionUID;
    }

    public Integer getIdIncident() {
        return idIncident;
    }

    public void setIdIncident(Integer idIncident) {
        this.idIncident = idIncident;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "idIncident=" + idIncident +
                ", ticket=" + ticket +
                ", user=" + user +
                ", dni='" + dni + '\'' +
                ", fullName='" + fullName + '\'' +
                ", date=" + date +
                '}';
    }
}
