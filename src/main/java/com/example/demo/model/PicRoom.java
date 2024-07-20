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
   name = "hinhanhphong"
)
public class PicRoom {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("TenHinhAnhPhong")
   @Column(
      name = "tenhinhanhphong"
   )
   private String TenHinhAnhPhong;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idphong"
   )
   private Room room;

   public PicRoom() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getTenHinhAnhPhong() {
      return this.TenHinhAnhPhong;
   }

   public Room getRoom() {
      return this.room;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("TenHinhAnhPhong")
   public void setTenHinhAnhPhong(final String TenHinhAnhPhong) {
      this.TenHinhAnhPhong = TenHinhAnhPhong;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public void setRoom(final Room room) {
      this.room = room;
   }
}
