package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Incident;

import java.util.List;

public interface IncidentService {

     List<Incident> findAllIncidents();

     Incident findIncidentById(Incident role);

     void insertIncident(Incident role);

     void updateIncident(Incident role);

     void deleteIncident(Incident role);

}
