// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByTenKhachHang(String tenKhachHang);

   Boolean existsByEmail(String Email);

   Optional<User> findByEmail(String Email);
}
