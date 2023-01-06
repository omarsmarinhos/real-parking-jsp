package com.RealParking.domain.dto;

import com.RealParking.domain.Role;

import java.util.Arrays;

public class UserDTO {
    private int idUser;
    private String username;
    private String password;
    private String fullName;

    private String state;

    private Role role;

    private byte[] photo;

    public UserDTO(int idUser, String username, String password, String fullName, String state, Role role, byte[] photo) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.state = state;
        this.role = role;
        this.photo = photo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", state='" + state + '\'' +
                ", role=" + role +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
