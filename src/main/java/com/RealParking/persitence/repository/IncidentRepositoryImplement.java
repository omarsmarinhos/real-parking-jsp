package com.RealParking.persitence.repository;

import com.RealParking.domain.service.IncidentService;
import com.RealParking.domain.service.IncidentServiceTestImpl;
import com.RealParking.persitence.entity.Incident;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class IncidentRepositoryImplement implements IncidentRepository{

    @Inject
    private IncidentService incidentService;

    @Override
    public List<Incident> listarIncidentes() {
        return incidentService.findAllIncidents();
    }

    @Override
    public Incident encontrarIncidentePorId(Incident incident) {
        return incidentService.findIncidentById(incident);
    }

    @Override
    public void registrarIncidente(Incident incident) {
        incidentService.insertIncident(incident);
    }

    @Override
    public void modificarIncidente(Incident incident) {
        incidentService.updateIncident(incident);
    }

    @Override
    public void eliminarIncidente(Incident incident) {
        incidentService.deleteIncident(incident);

    }
}
