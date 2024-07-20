// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.PaymentBill;
import com.example.demo.repository.PaymentBillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentBillService {
   @Autowired
   private PaymentBillRepository paymentBillRepository;

   public PaymentBillService() {
   }

   public List<PaymentBill> getAllPaymentBills() {
      return this.paymentBillRepository.findAll();
   }

   public Optional<PaymentBill> getPaymentBillById(Long id) {
      return this.paymentBillRepository.findById(id);
   }

   public PaymentBill savePaymentBill(PaymentBill paymentBill) {
      return (PaymentBill)this.paymentBillRepository.save(paymentBill);
   }

   public PaymentBill updatePaymentBill(Long id, PaymentBill updatedPaymentBill) {
      return (PaymentBill)this.paymentBillRepository.findById(id).map((paymentBill) -> {
         paymentBill.setNgayTao(updatedPaymentBill.getNgayTao());
         paymentBill.setTongTien(updatedPaymentBill.getTongTien());
         paymentBill.setTrangThai(updatedPaymentBill.getTrangThai());
         paymentBill.setChiTietSoLuong(updatedPaymentBill.getChiTietSoLuong());
         return (PaymentBill)this.paymentBillRepository.save(paymentBill);
      }).orElseThrow(() -> {
         return new RuntimeException("PaymentBill not found with id " + String.valueOf(id));
      });
   }

   public void deletePaymentBill(Long id) {
      this.paymentBillRepository.deleteById(id);
   }
}
