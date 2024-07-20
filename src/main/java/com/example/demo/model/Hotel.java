// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "khachsan"
)
public class Hotel {
   @Id
   @JsonProperty("ID")
   @Column(
      name = "ID"
   )
   private String ID;
   @JsonProperty("TenKhachSan")
   @Column(
      name = "tenkhachsan"
   )
   private String TenKhachSan;
   @JsonProperty("DiaChi")
   @Column(
      name = "diachi"
   )
   private String DiaChi;
   @JsonProperty("HinhAnhKS")
   @Column(
      name = "hinhanhks"
   )
   private String HinhAnhKS;
   @JsonProperty("SDT")
   @Column(
      name = "SDT"
   )
   private String SDT;
   @JsonProperty("DanhGia")
   @Column(
      name = "danhgia"
   )
   private Float DanhGia;
   @JsonProperty("MoTa")
   @Column(
      name = "mota"
   )
   private String MoTa;

   public Hotel() {
   }

   public Hotel(String iD, String tenKhachSan, String diaChi, String hinhAnhKS, String sDT, Float danhGia, String moTa) {
      this.ID = iD;
      this.TenKhachSan = tenKhachSan;
      this.DiaChi = diaChi;
      this.HinhAnhKS = hinhAnhKS;
      this.SDT = sDT;
      this.DanhGia = danhGia;
      this.MoTa = moTa;
   }

   public String getID() {
      return this.ID;
   }

   public String getTenKhachSan() {
      return this.TenKhachSan;
   }

   public String getDiaChi() {
      return this.DiaChi;
   }

   public String getHinhAnhKS() {
      return this.HinhAnhKS;
   }

   public String getSDT() {
      return this.SDT;
   }

   public Float getDanhGia() {
      return this.DanhGia;
   }

   public String getMoTa() {
      return this.MoTa;
   }

   @JsonProperty("ID")
   public void setID(final String ID) {
      this.ID = ID;
   }

   @JsonProperty("TenKhachSan")
   public void setTenKhachSan(final String TenKhachSan) {
      this.TenKhachSan = TenKhachSan;
   }

   @JsonProperty("DiaChi")
   public void setDiaChi(final String DiaChi) {
      this.DiaChi = DiaChi;
   }

   @JsonProperty("HinhAnhKS")
   public void setHinhAnhKS(final String HinhAnhKS) {
      this.HinhAnhKS = HinhAnhKS;
   }

   @JsonProperty("SDT")
   public void setSDT(final String SDT) {
      this.SDT = SDT;
   }

   @JsonProperty("DanhGia")
   public void setDanhGia(final Float DanhGia) {
      this.DanhGia = DanhGia;
   }

   @JsonProperty("MoTa")
   public void setMoTa(final String MoTa) {
      this.MoTa = MoTa;
   }
}
