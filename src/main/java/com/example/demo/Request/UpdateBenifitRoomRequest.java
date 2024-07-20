// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateBenifitRoomRequest {
   @JsonProperty("LoiIchRiengTu")
   private String LoiIchRiengTu;
   @JsonProperty("IDPhong")
   private Long IDPhong;

   public UpdateBenifitRoomRequest() {
   }

   public String getLoiIchRiengTu() {
      return this.LoiIchRiengTu;
   }

   public Long getIDPhong() {
      return this.IDPhong;
   }

   @JsonProperty("LoiIchRiengTu")
   public void setLoiIchRiengTu(final String LoiIchRiengTu) {
      this.LoiIchRiengTu = LoiIchRiengTu;
   }

   @JsonProperty("IDPhong")
   public void setIDPhong(final Long IDPhong) {
      this.IDPhong = IDPhong;
   }
}
