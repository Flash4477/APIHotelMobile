// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPaymentDetailRequest {
   @JsonProperty("IDPhong")
   private Long IDPhong;
   @JsonProperty("IDHoaDonThanhToan")
   private Long IDHoaDonThanhToan;
   @JsonProperty("IDKhachHang")
   private Long IDKhachHang;

   public AddPaymentDetailRequest() {
   }

   public Long getIDPhong() {
      return this.IDPhong;
   }

   public Long getIDHoaDonThanhToan() {
      return this.IDHoaDonThanhToan;
   }

   public Long getIDKhachHang() {
      return this.IDKhachHang;
   }

   @JsonProperty("IDPhong")
   public void setIDPhong(final Long IDPhong) {
      this.IDPhong = IDPhong;
   }

   @JsonProperty("IDHoaDonThanhToan")
   public void setIDHoaDonThanhToan(final Long IDHoaDonThanhToan) {
      this.IDHoaDonThanhToan = IDHoaDonThanhToan;
   }

   @JsonProperty("IDKhachHang")
   public void setIDKhachHang(final Long IDKhachHang) {
      this.IDKhachHang = IDKhachHang;
   }
}
