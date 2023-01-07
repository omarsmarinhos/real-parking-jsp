package com.RealParking.domain.dto;

import java.time.LocalDateTime;

public class TicketDTO {

    private int idTicket;
    private String placa;
    private LocalDateTime horaIngreso;

    private LocalDateTime horaSalida;

    private String state;

    public TicketDTO(int idTicket, String placa, LocalDateTime horaIngreso, LocalDateTime horaSalida, String state) {
        this.idTicket = idTicket;
        this.placa = placa;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.state = state;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "idTicket=" + idTicket +
                ", placa='" + placa + '\'' +
                ", horaIngreso=" + horaIngreso +
                ", horaSalida=" + horaSalida +
                ", state='" + state + '\'' +
                '}';
    }
}
