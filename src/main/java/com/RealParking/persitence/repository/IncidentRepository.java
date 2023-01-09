package com.RealParking.persitence.repository;

import com.RealParking.persitence.entity.Incident;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface IncidentRepository {

     List<Incident> listarIncidentes();

     Incident encontrarIncidentePorId(Incident incident);

     void registrarIncidente(Incident incident);

     void modificarIncidente(Incident incident);

     void eliminarIncidente(Incident incident);

}
