// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddConvenientHotelRequest {
   @JsonProperty("AmThuc")
   private String AmThuc;
   @JsonProperty("TienNghiCongCong")
   private String TienNghiCongCong;
   @JsonProperty("GiaiTriTheThao")
   private String GiaiTriTheThao;
   @JsonProperty("TienIchChung")
   private String TienIchChung;
   @JsonProperty("TreEmVaThuCung")
   private String TreEmVaThuCung;
   @JsonProperty("PhuongTien")
   private String PhuongTien;
   @JsonProperty("IDKhachSan")
   private String IDKhachSan;

   public AddConvenientHotelRequest() {
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

   public String getIDKhachSan() {
      return this.IDKhachSan;
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

   @JsonProperty("IDKhachSan")
   public void setIDKhachSan(final String IDKhachSan) {
      this.IDKhachSan = IDKhachSan;
   }
}
