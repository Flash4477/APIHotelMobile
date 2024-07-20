// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "loaiphong"
)
public class TypeRoom {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @JsonProperty("id")
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("TenLoai")
   @Column(
      name = "tenloai"
   )
   private String TenLoai;
   @JsonProperty("TienIchChung")
   @Column(
      name = "tienichchung"
   )
   private String TienIchChung;
   @JsonProperty("LoiIchChung")
   @Column(
      name = "loiichchung"
   )
   private String LoiIchChung;
   @ManyToOne
   @JoinColumn(
      name = "idkhachsan",
      referencedColumnName = "id"
   )
   @JsonProperty("IDKhachSan")
   private Hotel hotel;

   public TypeRoom() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getTenLoai() {
      return this.TenLoai;
   }

   public String getTienIchChung() {
      return this.TienIchChung;
   }

   public String getLoiIchChung() {
      return this.LoiIchChung;
   }

   public Hotel getHotel() {
      return this.hotel;
   }

   @JsonProperty("id")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("TenLoai")
   public void setTenLoai(final String TenLoai) {
      this.TenLoai = TenLoai;
   }

   @JsonProperty("TienIchChung")
   public void setTienIchChung(final String TienIchChung) {
      this.TienIchChung = TienIchChung;
   }

   @JsonProperty("LoiIchChung")
   public void setLoiIchChung(final String LoiIchChung) {
      this.LoiIchChung = LoiIchChung;
   }

   @JsonProperty("IDKhachSan")
   public void setHotel(final Hotel hotel) {
      this.hotel = hotel;
   }

   public TypeRoom(final Long ID, final String TenLoai, final String TienIchChung, final String LoiIchChung, final Hotel hotel) {
      this.ID = ID;
      this.TenLoai = TenLoai;
      this.TienIchChung = TienIchChung;
      this.LoiIchChung = LoiIchChung;
      this.hotel = hotel;
   }
}
