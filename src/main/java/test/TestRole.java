package test;

import com.RealParking.persitence.entity.Role;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class TestRole {
    private static EntityManagerFactory emf;
    private static EntityManager manager;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        manager = emf.createEntityManager();


        List<Role> roles = (List<Role>) manager.createQuery("FROM Role",Role.class).getResultList();

        for (Role role:
             roles) {
            System.out.println("idRol:"+role.getIdRol()+"\n");
            System.out.println("Descripcion:"+role.getDescription()+"\n");
            System.out.println("Estado:"+role.getState()+"\n");

        }


    }


}
