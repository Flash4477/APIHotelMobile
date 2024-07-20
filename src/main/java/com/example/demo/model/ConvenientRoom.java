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
@Table(
   name = "tiennghiphong"
)
public class ConvenientRoom {
   @Id
   @JsonProperty("ID")
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("TienNghiRiengTu")
   @Column(
      name = "tiennghiriengtu"
   )
   private String TienNghiRiengTu;
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @JoinColumn(
      name = "idphong"
   )
   private Room room;

   public ConvenientRoom() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getTienNghiRiengTu() {
      return this.TienNghiRiengTu;
   }

   public Room getRoom() {
      return this.room;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("TienNghiRiengTu")
   public void setTienNghiRiengTu(final String TienNghiRiengTu) {
      this.TienNghiRiengTu = TienNghiRiengTu;
   }

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public void setRoom(final Room room) {
      this.room = room;
   }
}
