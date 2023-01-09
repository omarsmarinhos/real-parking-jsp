package com.RealParking.persitence.repository;

import com.RealParking.domain.service.VoucherService;
import com.RealParking.persitence.entity.Voucher;
import jakarta.inject.Inject;

import java.util.List;

public class VoucherRepositoryImplement implements VoucherRepository{

    @Inject
    VoucherService voucherService;

    @Override
    public List<Voucher> listarVouchers() {
        return voucherService.findAllVouchers();
    }

    @Override
    public Voucher encontrarVoucherPorId(Voucher voucher) {
        return voucherService.findVoucherById(voucher);
    }

    @Override
    public void registrarVoucher(Voucher voucher) {
        voucherService.insertVoucher(voucher);
    }

    @Override
    public void modificarVoucher(Voucher voucher) {
        voucherService.updateVoucher(voucher);
    }

    @Override
    public void eliminarVoucher(Voucher voucher) {
        voucherService.deleteVoucher(voucher);
    }
}
