// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "hoadonthanhtoan"
)
public class PaymentBill {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("NgayTao")
   @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm"
   )
   @Column(
      name = "ngaytao",
      updatable = false,
      nullable = false
   )
   private LocalDateTime NgayTao;
   @JsonProperty("TongTien")
   @Column(
      name = "tongtien",
      nullable = false
   )
   private BigDecimal TongTien;
   @JsonProperty("TrangThai")
   @Column(
      name = "trangthai"
   )
   private String TrangThai;
   @JsonProperty("ChiTietSoLuong")
   @Column(
      name = "chitietsoluong"
   )
   private Integer ChiTietSoLuong;

   public PaymentBill() {
   }

   @PrePersist
   protected void onCreate() {
      this.NgayTao = LocalDateTime.now();
   }

   public Long getID() {
      return this.ID;
   }

   public LocalDateTime getNgayTao() {
      return this.NgayTao;
   }

   public BigDecimal getTongTien() {
      return this.TongTien;
   }

   public String getTrangThai() {
      return this.TrangThai;
   }

   public Integer getChiTietSoLuong() {
      return this.ChiTietSoLuong;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("NgayTao")
   @JsonFormat(
      pattern = "yyyy-MM-dd'T'HH:mm"
   )
   public void setNgayTao(final LocalDateTime NgayTao) {
      this.NgayTao = NgayTao;
   }

   @JsonProperty("TongTien")
   public void setTongTien(final BigDecimal TongTien) {
      this.TongTien = TongTien;
   }

   @JsonProperty("TrangThai")
   public void setTrangThai(final String TrangThai) {
      this.TrangThai = TrangThai;
   }

   @JsonProperty("ChiTietSoLuong")
   public void setChiTietSoLuong(final Integer ChiTietSoLuong) {
      this.ChiTietSoLuong = ChiTietSoLuong;
   }
}
