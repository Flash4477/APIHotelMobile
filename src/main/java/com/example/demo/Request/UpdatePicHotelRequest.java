// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePicHotelRequest {
   @JsonProperty("TenHinhAnhKS")
   private String TenHinhAnhKS;
   @JsonProperty("IDKhachSan")
   private String IDKhachSan;

   public UpdatePicHotelRequest() {
   }

   public String getTenHinhAnhKS() {
      return this.TenHinhAnhKS;
   }

   public String getIDKhachSan() {
      return this.IDKhachSan;
   }

   @JsonProperty("TenHinhAnhKS")
   public void setTenHinhAnhKS(final String TenHinhAnhKS) {
      this.TenHinhAnhKS = TenHinhAnhKS;
   }

   @JsonProperty("IDKhachSan")
   public void setIDKhachSan(final String IDKhachSan) {
      this.IDKhachSan = IDKhachSan;
   }
}
