// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddTypeRoomRequest {
   @JsonProperty("TenLoai")
   private String TenLoai;
   @JsonProperty("TienIchChung")
   private String TienIchChung;
   @JsonProperty("LoiIchChung")
   private String LoiIchChung;
   @JsonProperty("IDKhachSan")
   private String IDKhachSan;

   public AddTypeRoomRequest() {
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

   public String getIDKhachSan() {
      return this.IDKhachSan;
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
   public void setIDKhachSan(final String IDKhachSan) {
      this.IDKhachSan = IDKhachSan;
   }
}
