package test;

import com.RealParking.persitence.entity.User;
import com.RealParking.persitence.entity.Voucher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestVoucher {
    private static EntityManagerFactory emf;
    private static EntityManager manager;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        manager = emf.createEntityManager();


        List<Voucher> vouchers =  manager.createQuery("FROM Voucher",Voucher.class).getResultList();



        for (Voucher voucher:
                vouchers) {
            System.out.println("idVoucher:"+voucher.getIdVoucher());
            System.out.println("ticket:"+voucher.getTicket());
            System.out.println("user:"+voucher.getUser());
            System.out.println("date:"+voucher.getDate());
            System.out.println("amount:"+voucher.getAmount());

        }


    }


}
