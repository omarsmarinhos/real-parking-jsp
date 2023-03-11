package com.RealParking.service;

import com.RealParking.persitence.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {

    Optional<String> getUsername(HttpServletRequest req);
}
