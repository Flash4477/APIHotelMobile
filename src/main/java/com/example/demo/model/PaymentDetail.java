// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(
   name = "chitietthanhtoan"
)
public class PaymentDetail {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @JsonProperty("ID")
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("IDPhong")
   @ManyToOne(
      fetch = FetchType.EAGER
   )
   @JoinColumn(
      name = "idphong"
   )
   private Room room;
   @JsonProperty("IDHoaDonThanhToan")
   @ManyToOne(
      fetch = FetchType.EAGER
   )
   @JoinColumn(
      name = "idhoadonthanhtoan"
   )
   private PaymentBill paymentBill;
   @JsonProperty("IDKhachHang")
   @ManyToOne(
      fetch = FetchType.EAGER
   )
   @JoinColumn(
      name = "idkhachhang"
   )
   private User user;

   public PaymentDetail() {
   }

   public Long getID() {
      return this.ID;
   }

   public Room getRoom() {
      return this.room;
   }

   public PaymentBill getPaymentBill() {
      return this.paymentBill;
   }

   public User getUser() {
      return this.user;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("IDPhong")
   public void setRoom(final Room room) {
      this.room = room;
   }

   @JsonProperty("IDHoaDonThanhToan")
   public void setPaymentBill(final PaymentBill paymentBill) {
      this.paymentBill = paymentBill;
   }

   @JsonProperty("IDKhachHang")
   public void setUser(final User user) {
      this.user = user;
   }
}
