// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.PaymentBill;
import com.example.demo.model.PaymentDetail;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repository.PaymentBillRepository;
import com.example.demo.repository.PaymentDetailRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.Request.AddPaymentDetailRequest;
import com.example.demo.Request.UpdatePaymentDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailService {
   @Autowired
   private PaymentDetailRepository paymentDetailRepository;
   @Autowired
   private RoomRepository roomRepository;
   @Autowired
   private PaymentBillRepository paymentBillRepository;
   @Autowired
   private UserRepository userRepository;

   public PaymentDetailService() {
   }

   public List<PaymentDetail> getAllPaymentDetails() {
      return this.paymentDetailRepository.findAll();
   }

   public PaymentDetail getPaymentDetailById(Long id) {
      return (PaymentDetail)this.paymentDetailRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PaymentDetail not found with id " + String.valueOf(id));
      });
   }

   public PaymentDetail createPaymentDetail(AddPaymentDetailRequest request) {
      PaymentDetail paymentDetail = new PaymentDetail();
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
      });
      paymentDetail.setRoom(room);
      PaymentBill paymentBill = (PaymentBill)this.paymentBillRepository.findById(request.getIDHoaDonThanhToan()).orElseThrow(() -> {
         return new RuntimeException("Payment Bill not found with id " + String.valueOf(request.getIDHoaDonThanhToan()));
      });
      paymentDetail.setPaymentBill(paymentBill);
      User user = (User)this.userRepository.findById(request.getIDKhachHang()).orElseThrow(() -> {
         return new RuntimeException("User not found with id " + String.valueOf(request.getIDKhachHang()));
      });
      paymentDetail.setUser(user);
      return (PaymentDetail)this.paymentDetailRepository.save(paymentDetail);
   }

   public PaymentDetail updatePaymentDetail(Long id, UpdatePaymentDetail request) {
      PaymentDetail paymentDetail = (PaymentDetail)this.paymentDetailRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("Payment Detail not found with id " + String.valueOf(id));
      });
      if (request.getIDPhong() != null) {
         Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
            return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
         });
         paymentDetail.setRoom(room);
      }

      if (request.getIDHoaDonThanhToan() != null) {
         PaymentBill paymentBill = (PaymentBill)this.paymentBillRepository.findById(request.getIDHoaDonThanhToan()).orElseThrow(() -> {
            return new RuntimeException("Payment Bill not found with id " + String.valueOf(request.getIDHoaDonThanhToan()));
         });
         paymentDetail.setPaymentBill(paymentBill);
      }

      if (request.getIDKhachHang() != null) {
         User user = (User)this.userRepository.findById(request.getIDKhachHang()).orElseThrow(() -> {
            return new RuntimeException("User not found with id " + String.valueOf(request.getIDKhachHang()));
         });
         paymentDetail.setUser(user);
      }

      return (PaymentDetail)this.paymentDetailRepository.save(paymentDetail);
   }

   public void deletePaymentDetail(Long id) {
      this.paymentDetailRepository.deleteById(id);
   }
}
