package com.RealParking.domain.dto;

public class RoleDTO {

    private int idRole;
    private String description;

    private String state;

    public RoleDTO(int idRole, String description, String state) {
        this.idRole = idRole;
        this.description = description;
        this.state = state;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
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
        return "RoleDTO{" +
                "idRole=" + idRole +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
