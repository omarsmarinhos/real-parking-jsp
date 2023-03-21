package com.RealParking.service;


import com.RealParking.persitence.entity.User;

import java.util.List;

public interface ReporteService {

    byte[] generarReporte(List<User> users);

}
