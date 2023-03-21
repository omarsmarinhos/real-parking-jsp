package com.RealParking.service;

import com.RealParking.persitence.entity.User;

import java.util.List;

public class ReporteExcelServiceImpl implements ReporteService {

    @Override
    public byte[] generarReporte(List<User> users) {
        return new byte[0];
    }
}
