package com.RealParking.persitence.service;

import com.RealParking.persitence.entity.Voucher;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class VoucherServiceImpl implements VoucherService{

    private EntityManagerFactory emf;
    private EntityManager em;

    public VoucherServiceImpl() {
        emf = Persistence.createEntityManagerFactory("RealParkingPersistence");
        em = emf.createEntityManager();
    }

    @Override
    public List<Voucher> findAllVouchers() {
        return em.createNamedQuery("Voucher.findAll").getResultList();
    }

    @Override
    public Voucher findVoucherById(Voucher voucher) {
        return em.find(Voucher.class,voucher.getIdVoucher());
    }

    @Override
    public void insertVoucher(Voucher voucher) {
        em.getTransaction().begin();
        em.persist(voucher);
        em.getTransaction().commit();
    }

    @Override
    public void updateVoucher(Voucher voucher) {
        em.getTransaction().begin();
        em.merge(voucher);
        em.getTransaction().commit();
    }

    @Override
    public void deleteVoucher(Voucher voucher) {
        em.getTransaction().begin();
        em.remove(em.merge(voucher));
        em.getTransaction().commit();
    }
}
