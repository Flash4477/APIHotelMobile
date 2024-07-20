// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   private final UserRepository userRepository;

   @Autowired
   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public List<User> getAllUsers() {
      return this.userRepository.findAll();
   }

   public Optional<User> getUserById(Long id) {
      return this.userRepository.findById(id);
   }

   public User addUser(User user) {
      return (User)this.userRepository.save(user);
   }

   public User updateUser(Long id, User user) {
      User existingUser = (User)this.userRepository.findById(id).orElseThrow(() -> {
         return new IllegalArgumentException("Invalid user ID: " + String.valueOf(id));
      });
      existingUser.setTenKhachHang(user.getTenKhachHang());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());
      existingUser.setSDT(user.getSDT());
      existingUser.setDiaChi(user.getDiaChi());
      existingUser.setHinhAnh(user.getHinhAnh());
      return (User)this.userRepository.save(existingUser);
   }

   public void deleteUser(Long id) {
      this.userRepository.deleteById(id);
   }
}
