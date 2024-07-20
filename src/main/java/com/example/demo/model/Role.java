// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "role"
)
public class Role {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @JsonProperty("ID")
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("NameRole")
   @Column(
      name = "namerole"
   )
   private String nameRole;

   public Role() {
   }

   public Long getID() {
      return this.ID;
   }

   public String getNameRole() {
      return this.nameRole;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("NameRole")
   public void setNameRole(final String nameRole) {
      this.nameRole = nameRole;
   }
}
