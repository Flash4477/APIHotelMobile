// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRoomRequest {
   @JsonProperty("Tenphong")
   private String Tenphong;
   @JsonProperty("Lau")
   private Integer Lau;
   @JsonProperty("DienTich")
   private String DienTich;
   @JsonProperty("TrangThai")
   private boolean TrangThai;
   @JsonProperty("MotaPhong")
   private String MotaPhong;
   @JsonProperty("GiaPhong")
   private Float GiaPhong;
   @JsonProperty("SoLuongKhach")
   private Integer SoLuongKhach;
   @JsonProperty("HinhAnh")
   private String HinhAnh;
   @JsonProperty("IDLoaiPhong")
   private Long IDLoaiPhong;

   public AddRoomRequest() {
   }

   public String getTenphong() {
      return this.Tenphong;
   }

   public Integer getLau() {
      return this.Lau;
   }

   public String getDienTich() {
      return this.DienTich;
   }

   public boolean isTrangThai() {
      return this.TrangThai;
   }

   public String getMotaPhong() {
      return this.MotaPhong;
   }

   public Float getGiaPhong() {
      return this.GiaPhong;
   }

   public Integer getSoLuongKhach() {
      return this.SoLuongKhach;
   }

   public String getHinhAnh() {
      return this.HinhAnh;
   }

   public Long getIDLoaiPhong() {
      return this.IDLoaiPhong;
   }

   @JsonProperty("Tenphong")
   public void setTenphong(final String Tenphong) {
      this.Tenphong = Tenphong;
   }

   @JsonProperty("Lau")
   public void setLau(final Integer Lau) {
      this.Lau = Lau;
   }

   @JsonProperty("DienTich")
   public void setDienTich(final String DienTich) {
      this.DienTich = DienTich;
   }

   @JsonProperty("TrangThai")
   public void setTrangThai(final boolean TrangThai) {
      this.TrangThai = TrangThai;
   }

   @JsonProperty("MotaPhong")
   public void setMotaPhong(final String MotaPhong) {
      this.MotaPhong = MotaPhong;
   }

   @JsonProperty("GiaPhong")
   public void setGiaPhong(final Float GiaPhong) {
      this.GiaPhong = GiaPhong;
   }

   @JsonProperty("SoLuongKhach")
   public void setSoLuongKhach(final Integer SoLuongKhach) {
      this.SoLuongKhach = SoLuongKhach;
   }

   @JsonProperty("HinhAnh")
   public void setHinhAnh(final String HinhAnh) {
      this.HinhAnh = HinhAnh;
   }

   @JsonProperty("IDLoaiPhong")
   public void setIDLoaiPhong(final Long IDLoaiPhong) {
      this.IDLoaiPhong = IDLoaiPhong;
   }
}
