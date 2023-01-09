package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Incident;
import jakarta.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class IncidentServiceTestImpl implements IncidentService{

    /*private EntityManagerFactory emf;
    private EntityManager em;

    public IncidentServiceTestImpl() {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        em = emf.createEntityManager();
    }*/

    @PersistenceContext(unitName="RealParkingPersistence")
    EntityManager em;


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
