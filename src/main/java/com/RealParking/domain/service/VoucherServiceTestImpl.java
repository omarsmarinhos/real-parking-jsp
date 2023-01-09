package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Voucher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class VoucherServiceTestImpl implements VoucherService{

    @PersistenceContext(unitName="RealParkingPersistence")
    EntityManager em;

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
        em.persist(voucher);
    }

    @Override
    public void updateVoucher(Voucher voucher) {
        em.merge(voucher);
    }

    @Override
    public void deleteVoucher(Voucher voucher) {
        em.remove(em.merge(voucher));
    }
}
