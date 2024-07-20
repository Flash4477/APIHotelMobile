// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateTypeRoomRequest {
   @JsonProperty("TenLoai")
   private String tenLoai;
   @JsonProperty("TienIchChung")
   private String tienIchChung;
   @JsonProperty("LoiIchChung")
   private String loiIchChung;
   @JsonProperty("IDKhachSan")
   private String idKhachSan;

   public UpdateTypeRoomRequest() {
   }

   public String getTenLoai() {
      return this.tenLoai;
   }

   public String getTienIchChung() {
      return this.tienIchChung;
   }

   public String getLoiIchChung() {
      return this.loiIchChung;
   }

   public String getIdKhachSan() {
      return this.idKhachSan;
   }

   @JsonProperty("TenLoai")
   public void setTenLoai(final String tenLoai) {
      this.tenLoai = tenLoai;
   }

   @JsonProperty("TienIchChung")
   public void setTienIchChung(final String tienIchChung) {
      this.tienIchChung = tienIchChung;
   }

   @JsonProperty("LoiIchChung")
   public void setLoiIchChung(final String loiIchChung) {
      this.loiIchChung = loiIchChung;
   }

   @JsonProperty("IDKhachSan")
   public void setIdKhachSan(final String idKhachSan) {
      this.idKhachSan = idKhachSan;
   }
}
