// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "userrole"
)
public class UserRole {
   @Id
   @ManyToOne
   @JoinColumn(
      name = "idkhachhang"
   )
   private User user;
   @Id
   @ManyToOne
   @JoinColumn(
      name = "idrole"
   )
   private Role role;

   public UserRole() {
   }

   public User getUser() {
      return this.user;
   }

   public Role getRole() {
      return this.role;
   }

   public void setUser(final User user) {
      this.user = user;
   }

   public void setRole(final Role role) {
      this.role = role;
   }
}
