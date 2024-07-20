// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPicRoomRequest {
   @JsonProperty("TenHinhAnhPhong")
   private String TenHinhAnhPhong;
   @JsonProperty("IDPhong")
   private Long IDPhong;

   public AddPicRoomRequest() {
   }

   public String getTenHinhAnhPhong() {
      return this.TenHinhAnhPhong;
   }

   public Long getIDPhong() {
      return this.IDPhong;
   }

   @JsonProperty("TenHinhAnhPhong")
   public void setTenHinhAnhPhong(final String TenHinhAnhPhong) {
      this.TenHinhAnhPhong = TenHinhAnhPhong;
   }

   @JsonProperty("IDPhong")
   public void setIDPhong(final Long IDPhong) {
      this.IDPhong = IDPhong;
   }
}
