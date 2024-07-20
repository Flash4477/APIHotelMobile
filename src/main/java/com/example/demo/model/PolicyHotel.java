// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.sql.Time;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(
   name = "chinhsachks"
)
public class PolicyHotel {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("GioNhanPhong")
   @Column(
      name = "gionhanphong",
      nullable = false
   )
   private Time GioNhanPhong;
   @JsonProperty("GioTraPhong")
   @Column(
      name = "giotraphong",
      nullable = false
   )
   private Time GioTraPhong;
   @JsonProperty("NoiDung")
   @Column(
      name = "noidung"
   )
   private String NoiDung;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idkhachsan",
      insertable = false,
      updatable = false
   )
   private Hotel hotel;

   public PolicyHotel() {
   }

   public Long getID() {
      return this.ID;
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

   public Hotel getHotel() {
      return this.hotel;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("GioNhanPhong")
   public void setGioNhanPhong(final Time GioNhanPhong) {
      this.GioNhanPhong = GioNhanPhong;
   }

   @JsonProperty("GioTraPhong")
   public void setGioTraPhong(final Time GioTraPhong) {
      this.GioTraPhong = GioTraPhong;
   }

   @JsonProperty("NoiDung")
   public void setNoiDung(final String NoiDung) {
      this.NoiDung = NoiDung;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public void setHotel(final Hotel hotel) {
      this.hotel = hotel;
   }
}
