package test;

import com.RealParking.persitence.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestUser {
    private static EntityManagerFactory emf;
    private static EntityManager manager;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        manager = emf.createEntityManager();


        List<User> users =  manager.createQuery("FROM User",User.class).getResultList();

        for (User user:
             users) {
            System.out.println(
                "idUser=" + user.getIdUser() +
                        ", username='" + user.getUsername() + '\'' +
                        ", password='" + user.getPassword() + '\'' +
                        ", fullName='" + user.getFullName() + '\'' +
                        ", state='" + user.getFullName() + '\'' +
                        ", role=" + user.getRole() +
                        '}');

        }


    }


}
