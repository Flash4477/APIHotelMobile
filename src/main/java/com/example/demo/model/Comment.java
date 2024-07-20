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
   name = "binhluan"
)
public class Comment {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("NoiDung")
   @Column(
      name = "noidung"
   )
   private String NoiDung;
   @JsonProperty("SoLuongThich")
   @Column(
      name = "soluongthich"
   )
   private Integer SoLuongThich;
   @JsonProperty("DanhGia")
   @Column(
      name = "danhgia"
   )
   private Integer DanhGia;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @JsonProperty("IDKhachSan")
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idkhachsan"
   )
   private Hotel hotel;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @JsonProperty("IDKhachHang")
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idkhachhang"
   )
   private User user;

   public Comment() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getNoiDung() {
      return this.NoiDung;
   }

   public Integer getSoLuongThich() {
      return this.SoLuongThich;
   }

   public Integer getDanhGia() {
      return this.DanhGia;
   }

   public Hotel getHotel() {
      return this.hotel;
   }

   public User getUser() {
      return this.user;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("NoiDung")
   public void setNoiDung(final String NoiDung) {
      this.NoiDung = NoiDung;
   }

   @JsonProperty("SoLuongThich")
   public void setSoLuongThich(final Integer SoLuongThich) {
      this.SoLuongThich = SoLuongThich;
   }

   @JsonProperty("DanhGia")
   public void setDanhGia(final Integer DanhGia) {
      this.DanhGia = DanhGia;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @JsonProperty("IDKhachSan")
   public void setHotel(final Hotel hotel) {
      this.hotel = hotel;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @JsonProperty("IDKhachHang")
   public void setUser(final User user) {
      this.user = user;
   }
}
