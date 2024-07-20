// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.PaymentBill;
import com.example.demo.service.PaymentBillService;
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
@RequestMapping({"/paymentbills"})
public class PaymentBillController {
   @Autowired
   private PaymentBillService paymentBillService;

   public PaymentBillController() {
   }

   @GetMapping({"/all"})
   public List<PaymentBill> getAllPaymentBills() {
      return this.paymentBillService.getAllPaymentBills();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<PaymentBill> getPaymentBillById(@PathVariable Long id) {
      return (ResponseEntity)this.paymentBillService.getPaymentBillById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
   }

   @PostMapping({"/create"})
   public PaymentBill createPaymentBill(@RequestBody PaymentBill paymentBill) {
      return this.paymentBillService.savePaymentBill(paymentBill);
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<PaymentBill> updatePaymentBill(@PathVariable Long id, @RequestBody PaymentBill paymentBill) {
      return ResponseEntity.ok(this.paymentBillService.updatePaymentBill(id, paymentBill));
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<Void> deletePaymentBill(@PathVariable Long id) {
      this.paymentBillService.deletePaymentBill(id);
      return ResponseEntity.noContent().build();
   }
}
