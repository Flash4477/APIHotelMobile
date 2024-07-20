// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Request;

public class RequestRegister {
   private String TenKhachHang;
   private String Email;
   private String Password;
   private String ConfirmPass;

   public String getTenKhachHang() {
      return this.TenKhachHang;
   }

   public String getEmail() {
      return this.Email;
   }

   public String getPassword() {
      return this.Password;
   }

   public String getConfirmPass() {
      return this.ConfirmPass;
   }

   public void setTenKhachHang(final String TenKhachHang) {
      this.TenKhachHang = TenKhachHang;
   }

   public void setEmail(final String Email) {
      this.Email = Email;
   }

   public void setPassword(final String Password) {
      this.Password = Password;
   }

   public void setConfirmPass(final String ConfirmPass) {
      this.ConfirmPass = ConfirmPass;
   }

   public RequestRegister(final String TenKhachHang, final String Email, final String Password, final String ConfirmPass) {
      this.TenKhachHang = TenKhachHang;
      this.Email = Email;
      this.Password = Password;
      this.ConfirmPass = ConfirmPass;
   }
}
