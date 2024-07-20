// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.PaymentDetail;
import com.example.demo.Request.AddPaymentDetailRequest;
import com.example.demo.Request.UpdatePaymentDetail;
import com.example.demo.service.PaymentDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping({"/paymentdetails"})
public class PaymentDetailController {
   @Autowired
   private PaymentDetailService paymentDetailService;

   public PaymentDetailController() {
   }

   @GetMapping({"/all"})
   public List<PaymentDetail> getAllPaymentDetails() {
      return this.paymentDetailService.getAllPaymentDetails();
   }

   @GetMapping({"/{id}"})
   public PaymentDetail getPaymentDetailById(@PathVariable Long id) {
      return this.paymentDetailService.getPaymentDetailById(id);
   }

   @PostMapping({"/create"})
   public ResponseEntity<PaymentDetail> createPaymentDetail(@RequestBody AddPaymentDetailRequest request) {
      PaymentDetail createdPaymentDetail = this.paymentDetailService.createPaymentDetail(request);
      return ResponseEntity.ok(createdPaymentDetail);
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<PaymentDetail> updatePaymentDetail(@PathVariable Long id, @RequestBody UpdatePaymentDetail request) {
      PaymentDetail updatedPaymentDetail = this.paymentDetailService.updatePaymentDetail(id, request);
      return ResponseEntity.ok(updatedPaymentDetail);
   }

   @DeleteMapping({"/delete/{id}"})
   public void deletePaymentDetail(@PathVariable Long id) {
      this.paymentDetailService.deletePaymentDetail(id);
   }
}
