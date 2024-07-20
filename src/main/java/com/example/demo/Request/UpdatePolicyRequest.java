// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.sql.Time;

public class UpdatePolicyRequest {
   @JsonProperty("GioNhanPhong")
   @JsonFormat(
      shape = Shape.STRING,
      pattern = "HH:mm:ss"
   )
   private Time GioNhanPhong;
   @JsonProperty("GioTraPhong")
   @JsonFormat(
      shape = Shape.STRING,
      pattern = "HH:mm:ss"
   )
   private Time GioTraPhong;
   @JsonProperty("NoiDung")
   private String NoiDung;
   @JsonProperty("IDKhachSan")
   private String IDKhachSan;

   public UpdatePolicyRequest() {
   }

   public Time getGioNhanPhong() {
      return this.GioNhanPhong;
   }

   public Time getGioTraPhong() {
      return this.GioTraPhong;
   }

   public String getNoiDung() {
      return this.NoiDung;
   }

   public String getIDKhachSan() {
      return this.IDKhachSan;
   }

   @JsonProperty("GioNhanPhong")
   @JsonFormat(
      shape = Shape.STRING,
      pattern = "HH:mm:ss"
   )
   public void setGioNhanPhong(final Time GioNhanPhong) {
      this.GioNhanPhong = GioNhanPhong;
   }

   @JsonProperty("GioTraPhong")
   @JsonFormat(
      shape = Shape.STRING,
      pattern = "HH:mm:ss"
   )
   public void setGioTraPhong(final Time GioTraPhong) {
      this.GioTraPhong = GioTraPhong;
   }

   @JsonProperty("NoiDung")
   public void setNoiDung(final String NoiDung) {
      this.NoiDung = NoiDung;
   }

   @JsonProperty("IDKhachSan")
   public void setIDKhachSan(final String IDKhachSan) {
      this.IDKhachSan = IDKhachSan;
   }
}
