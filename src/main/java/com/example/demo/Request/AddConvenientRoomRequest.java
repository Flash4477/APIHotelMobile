// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddConvenientRoomRequest {
   @JsonProperty("TienNghiRiengTu")
   private String TienNghiRiengTu;
   @JsonProperty("IDPhong")
   private Long IDPhong;

   public AddConvenientRoomRequest() {
   }

   public String getTienNghiRiengTu() {
      return this.TienNghiRiengTu;
   }

   public Long getIDPhong() {
      return this.IDPhong;
   }

   @JsonProperty("TienNghiRiengTu")
   public void setTienNghiRiengTu(final String TienNghiRiengTu) {
      this.TienNghiRiengTu = TienNghiRiengTu;
   }

   @JsonProperty("IDPhong")
   public void setIDPhong(final Long IDPhong) {
      this.IDPhong = IDPhong;
   }
}
