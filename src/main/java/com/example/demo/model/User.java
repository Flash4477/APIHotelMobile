// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(
   name = "khachhang"
)
public class User implements UserDetails {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @JsonProperty("ID")
   @Column(
      name = "id"
   )
   private Long ID;
   @JsonProperty("TenKhachHang")
   @Column(
      name = "tenkhachhang"
   )
   private String tenKhachHang;
   @JsonProperty("Email")
   @Column(
      name = "email"
   )
   private String email;
   @JsonProperty("Password")
   @Column(
      name = "password"
   )
   private String Password;
   @JsonProperty("SDT")
   @Column(
      name = "sdt"
   )
   private String SDT;
   @JsonProperty("DiaChi")
   @Column(
      name = "diachi"
   )
   private String DiaChi;
   @JsonProperty("HinhAnh")
   @Column(
      name = "hinhanh"
   )
   private String HinhAnh;
   @ManyToMany(
      fetch = FetchType.EAGER,
      cascade = {CascadeType.ALL}
   )
   @JoinTable(
      name = "userrole",
      joinColumns = {@JoinColumn(
   name = "idkhachhang"
)},
      inverseJoinColumns = {@JoinColumn(
   name = "idrole"
)}
   )
   private List<Role> roles = new ArrayList();

   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.mapRolesToAuthorities(this.roles);
   }

   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
      return (Collection)roles.stream().map((role) -> {
         return new SimpleGrantedAuthority(role.getNameRole());
      }).collect(Collectors.toList());
   }

   public String getUsername() {
      return this.tenKhachHang;
   }

   public String getPassword() {
      return this.Password;
   }

   public boolean isAccountNonExpired() {
      return true;
   }

   public boolean isAccountNonLocked() {
      return true;
   }

   public boolean isCredentialsNonExpired() {
      return true;
   }

   public boolean isEnabled() {
      return true;
   }

   public User() {
   }

   public User(Long iD, String tenKhachHang, String email, String password, String sDT, String diaChi, String hinhAnh, List<Role> roles) {
      this.ID = iD;
      this.tenKhachHang = tenKhachHang;
      this.email = email;
      this.Password = password;
      this.SDT = sDT;
      this.DiaChi = diaChi;
      this.HinhAnh = hinhAnh;
      this.roles = roles;
   }

   public Long getID() {
      return this.ID;
   }

   public String getTenKhachHang() {
      return this.tenKhachHang;
   }

   public String getEmail() {
      return this.email;
   }

   public String getSDT() {
      return this.SDT;
   }

   public String getDiaChi() {
      return this.DiaChi;
   }

   public String getHinhAnh() {
      return this.HinhAnh;
   }

   public List<Role> getRoles() {
      return this.roles;
   }

   @JsonProperty("ID")
   public void setID(final Long ID) {
      this.ID = ID;
   }

   @JsonProperty("TenKhachHang")
   public void setTenKhachHang(final String tenKhachHang) {
      this.tenKhachHang = tenKhachHang;
   }

   @JsonProperty("Email")
   public void setEmail(final String email) {
      this.email = email;
   }

   @JsonProperty("Password")
   public void setPassword(final String Password) {
      this.Password = Password;
   }

   @JsonProperty("SDT")
   public void setSDT(final String SDT) {
      this.SDT = SDT;
   }

   @JsonProperty("DiaChi")
   public void setDiaChi(final String DiaChi) {
      this.DiaChi = DiaChi;
   }

   @JsonProperty("HinhAnh")
   public void setHinhAnh(final String HinhAnh) {
      this.HinhAnh = HinhAnh;
   }

   public void setRoles(final List<Role> roles) {
      this.roles = roles;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof User)) {
         return false;
      } else {
         User other = (User)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            label107: {
               Object this$ID = this.getID();
               Object other$ID = other.getID();
               if (this$ID == null) {
                  if (other$ID == null) {
                     break label107;
                  }
               } else if (this$ID.equals(other$ID)) {
                  break label107;
               }

               return false;
            }

            Object this$tenKhachHang = this.getTenKhachHang();
            Object other$tenKhachHang = other.getTenKhachHang();
            if (this$tenKhachHang == null) {
               if (other$tenKhachHang != null) {
                  return false;
               }
            } else if (!this$tenKhachHang.equals(other$tenKhachHang)) {
               return false;
            }

            Object this$email = this.getEmail();
            Object other$email = other.getEmail();
            if (this$email == null) {
               if (other$email != null) {
                  return false;
               }
            } else if (!this$email.equals(other$email)) {
               return false;
            }

            label86: {
               Object this$Password = this.getPassword();
               Object other$Password = other.getPassword();
               if (this$Password == null) {
                  if (other$Password == null) {
                     break label86;
                  }
               } else if (this$Password.equals(other$Password)) {
                  break label86;
               }

               return false;
            }

            label79: {
               Object this$SDT = this.getSDT();
               Object other$SDT = other.getSDT();
               if (this$SDT == null) {
                  if (other$SDT == null) {
                     break label79;
                  }
               } else if (this$SDT.equals(other$SDT)) {
                  break label79;
               }

               return false;
            }

            label72: {
               Object this$DiaChi = this.getDiaChi();
               Object other$DiaChi = other.getDiaChi();
               if (this$DiaChi == null) {
                  if (other$DiaChi == null) {
                     break label72;
                  }
               } else if (this$DiaChi.equals(other$DiaChi)) {
                  break label72;
               }

               return false;
            }

            Object this$HinhAnh = this.getHinhAnh();
            Object other$HinhAnh = other.getHinhAnh();
            if (this$HinhAnh == null) {
               if (other$HinhAnh != null) {
                  return false;
               }
            } else if (!this$HinhAnh.equals(other$HinhAnh)) {
               return false;
            }

            Object this$roles = this.getRoles();
            Object other$roles = other.getRoles();
            if (this$roles == null) {
               if (other$roles != null) {
                  return false;
               }
            } else if (!this$roles.equals(other$roles)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof User;
   }

   public int hashCode() {
      boolean PRIME = true;
      int result = 1;
      Object $ID = this.getID();
      result = result * 59 + ($ID == null ? 43 : $ID.hashCode());
      Object $tenKhachHang = this.getTenKhachHang();
      result = result * 59 + ($tenKhachHang == null ? 43 : $tenKhachHang.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $Password = this.getPassword();
      result = result * 59 + ($Password == null ? 43 : $Password.hashCode());
      Object $SDT = this.getSDT();
      result = result * 59 + ($SDT == null ? 43 : $SDT.hashCode());
      Object $DiaChi = this.getDiaChi();
      result = result * 59 + ($DiaChi == null ? 43 : $DiaChi.hashCode());
      Object $HinhAnh = this.getHinhAnh();
      result = result * 59 + ($HinhAnh == null ? 43 : $HinhAnh.hashCode());
      Object $roles = this.getRoles();
      result = result * 59 + ($roles == null ? 43 : $roles.hashCode());
      return result;
   }

   public String toString() {
      String var10000 = String.valueOf(this.getID());
      return "User(ID=" + var10000 + ", tenKhachHang=" + this.getTenKhachHang() + ", email=" + this.getEmail() + ", Password=" + this.getPassword() + ", SDT=" + this.getSDT() + ", DiaChi=" + this.getDiaChi() + ", HinhAnh=" + this.getHinhAnh() + ", roles=" + String.valueOf(this.getRoles()) + ")";
   }
}
