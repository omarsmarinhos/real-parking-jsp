package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Incident;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class IncidentServiceImpl implements IncidentService{

    private EntityManagerFactory emf;
    private EntityManager em;

    public IncidentServiceImpl() {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        em = emf.createEntityManager();
    }

    @Override
    public List<Incident> findAllIncidents() {
        return em.createNamedQuery("Incident.findAll").getResultList();
    }

    @Override
    public Incident findIncidentById(Incident incident) {
        return em.find(Incident.class,incident.getIdIncident());
    }

    @Override
    public void insertIncident(Incident incident) {
        em.persist(incident);
    }

    @Override
    public void updateIncident(Incident incident) {
        em.merge(incident);
    }

    @Override
    public void deleteIncident(Incident incident) {
        em.remove(em.merge(incident));
    }
}
