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
@Table(
   name = "thuantienkhachsan"
)
public class ConvenientHotel {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("AmThuc")
   @Column(
      name = "amthuc"
   )
   private String AmThuc;
   @JsonProperty("TienNghiCongCong")
   @Column(
      name = "tiennghicongcong"
   )
   private String TienNghiCongCong;
   @JsonProperty("GiaiTriTheThao")
   @Column(
      name = "giaitrithethao"
   )
   private String GiaiTriTheThao;
   @JsonProperty("TienIchChung")
   @Column(
      name = "tienichchung"
   )
   private String TienIchChung;
   @JsonProperty("TreEmVaThuCung")
   @Column(
      name = "treemvathucung"
   )
   private String TreEmVaThuCung;
   @JsonProperty("PhuongTien")
   @Column(
      name = "phuongtien"
   )
   private String PhuongTien;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idkhachsan"
   )
   private Hotel hotel;

   public ConvenientHotel() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getAmThuc() {
      return this.AmThuc;
   }

   public String getTienNghiCongCong() {
      return this.TienNghiCongCong;
   }

   public String getGiaiTriTheThao() {
      return this.GiaiTriTheThao;
   }

   public String getTienIchChung() {
      return this.TienIchChung;
   }

   public String getTreEmVaThuCung() {
      return this.TreEmVaThuCung;
   }

   public String getPhuongTien() {
      return this.PhuongTien;
   }

   public Hotel getHotel() {
      return this.hotel;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("AmThuc")
   public void setAmThuc(final String AmThuc) {
      this.AmThuc = AmThuc;
   }

   @JsonProperty("TienNghiCongCong")
   public void setTienNghiCongCong(final String TienNghiCongCong) {
      this.TienNghiCongCong = TienNghiCongCong;
   }

   @JsonProperty("GiaiTriTheThao")
   public void setGiaiTriTheThao(final String GiaiTriTheThao) {
      this.GiaiTriTheThao = GiaiTriTheThao;
   }

   @JsonProperty("TienIchChung")
   public void setTienIchChung(final String TienIchChung) {
      this.TienIchChung = TienIchChung;
   }

   @JsonProperty("TreEmVaThuCung")
   public void setTreEmVaThuCung(final String TreEmVaThuCung) {
      this.TreEmVaThuCung = TreEmVaThuCung;
   }

   @JsonProperty("PhuongTien")
   public void setPhuongTien(final String PhuongTien) {
      this.PhuongTien = PhuongTien;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public void setHotel(final Hotel hotel) {
      this.hotel = hotel;
   }
}
