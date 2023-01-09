package com.RealParking.persitence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@NamedQueries({
        @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
})
public class Ticket implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;

    @Column(name = "placa")
    private String numberPlate;

    @Column(name = "hora_ingreso")

    private LocalDateTime hourEntry;

    @Column(name = "hora_salida")
    private LocalDateTime departureTime;

    @Column(name = "estado")
    private String state;

    public Ticket() {
    }

    public Ticket(Integer idTicket, String numberPlate, LocalDateTime hourEntry, LocalDateTime departureTime, String state) {
        this.idTicket = idTicket;
        this.numberPlate = numberPlate;
        this.hourEntry = hourEntry;
        this.departureTime = departureTime;
        this.state = state;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public LocalDateTime getHourEntry() {
        return hourEntry;
    }

    public void setHourEntry(LocalDateTime hourEntry) {
        this.hourEntry = hourEntry;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", numberPlate='" + numberPlate + '\'' +
                ", hourEntry=" + hourEntry +
                ", departureTime=" + departureTime +
                ", state='" + state + '\'' +
                '}';
    }
}
