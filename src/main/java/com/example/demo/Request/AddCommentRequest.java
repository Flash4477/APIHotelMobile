// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCommentRequest {
   @JsonProperty("NoiDung")
   private String NoiDung;
   @JsonProperty("DanhGia")
   private Integer DanhGia;
   @JsonProperty("IDKhachSan")
   private String IDKhachSan;
   @JsonProperty("IDKhachHang")
   private Long IDKhachHang;

   public AddCommentRequest() {
   }

   public String getNoiDung() {
      return this.NoiDung;
   }

   public Integer getDanhGia() {
      return this.DanhGia;
   }

   public String getIDKhachSan() {
      return this.IDKhachSan;
   }

   public Long getIDKhachHang() {
      return this.IDKhachHang;
   }

   @JsonProperty("NoiDung")
   public void setNoiDung(final String NoiDung) {
      this.NoiDung = NoiDung;
   }

   @JsonProperty("DanhGia")
   public void setDanhGia(final Integer DanhGia) {
      this.DanhGia = DanhGia;
   }

   @JsonProperty("IDKhachSan")
   public void setIDKhachSan(final String IDKhachSan) {
      this.IDKhachSan = IDKhachSan;
   }

   @JsonProperty("IDKhachHang")
   public void setIDKhachHang(final Long IDKhachHang) {
      this.IDKhachHang = IDKhachHang;
   }
}
