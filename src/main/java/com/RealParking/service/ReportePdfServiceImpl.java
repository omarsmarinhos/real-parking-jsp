package com.RealParking.service;

import com.RealParking.configs.Service;
import com.RealParking.configs.UserServicePrinc;
import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.repositories.RepositoryJpa;
import com.RealParking.persitence.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.List;

@Service
public class ReportePdfServiceImpl implements ReporteService{

    @Override
    public byte[] generarReporte(List<User> users) {
        return null;
    }
}
