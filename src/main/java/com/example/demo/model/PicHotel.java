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

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(
   name = "hinhanhks"
)
public class PicHotel {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("TenHinhAnhKS")
   @Column(
      name = "tenhinhanhks"
   )
   private String TenHinhAnhKS;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idkhachsan"
   )
   private Hotel hotel;

   public PicHotel() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getTenHinhAnhKS() {
      return this.TenHinhAnhKS;
   }

   public Hotel getHotel() {
      return this.hotel;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("TenHinhAnhKS")
   public void setTenHinhAnhKS(final String TenHinhAnhKS) {
      this.TenHinhAnhKS = TenHinhAnhKS;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public void setHotel(final Hotel hotel) {
      this.hotel = hotel;
   }
}
