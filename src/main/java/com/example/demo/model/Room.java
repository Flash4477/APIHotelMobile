// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "phong"
)
public class Room {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("Tenphong")
   @Column(
      name = "tenphong"
   )
   private String Tenphong;
   @JsonProperty("Lau")
   @Column(
      name = "lau"
   )
   private Integer Lau;
   @JsonProperty("DienTich")
   @Column(
      name = "dientich"
   )
   private String DienTich;
   @JsonProperty("TrangThai")
   @Column(
      name = "trangthai"
   )
   private boolean TrangThai;
   @JsonProperty("MotaPhong")
   @Column(
      name = "motaphong"
   )
   private String MotaPhong;
   @JsonProperty("GiaPhong")
   @Column(
      name = "giaphong"
   )
   private Float GiaPhong;
   @JsonProperty("SoLuongKhach")
   @Column(
      name = "soluongkhach"
   )
   private Integer SoLuongKhach;
   @JsonProperty("HinhAnh")
   @Column(
      name = "hinhanh"
   )
   private String HinhAnh;
   @JsonProperty("IDLoaiPhong")
   @ManyToOne(
      fetch = FetchType.EAGER
   )
   @JoinColumn(
      name = "idloaiphong"
   )
   private TypeRoom typeroom;

   public Room() {
   }

   public Long getID() {
      return this.ID;
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

   public TypeRoom getTyperoom() {
      return this.typeroom;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
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
   public void setTyperoom(final TypeRoom typeroom) {
      this.typeroom = typeroom;
   }
}
