package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Incident;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        em.getTransaction().begin();
        em.persist(incident);
        em.getTransaction().commit();
    }

    @Override
    public void updateIncident(Incident incident) {
        em.getTransaction().begin();
        em.merge(incident);
        em.getTransaction().commit();
    }

    @Override
    public void deleteIncident(Incident incident) {
        em.getTransaction().begin();
        em.remove(em.merge(incident));
        em.getTransaction().commit();
    }
}
