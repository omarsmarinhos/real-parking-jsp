package com.RealParking.domain.service;

import com.RealParking.persitence.entity.Voucher;

import java.util.List;

public interface VoucherService {

     List<Voucher> findAllVouchers();

     Voucher findVoucherById(Voucher voucher);

     void insertVoucher(Voucher voucher);

     void updateVoucher(Voucher voucher);

     void deleteVoucher(Voucher voucher);

}
