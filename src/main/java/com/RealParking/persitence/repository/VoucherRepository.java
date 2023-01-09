package com.RealParking.persitence.repository;

import com.RealParking.persitence.entity.Voucher;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface VoucherRepository {

     List<Voucher> listarVouchers();

     Voucher encontrarVoucherPorId(Voucher voucher);

     void registrarVoucher(Voucher voucher);

     void modificarVoucher(Voucher voucher);

     void eliminarVoucher(Voucher voucher);

}
