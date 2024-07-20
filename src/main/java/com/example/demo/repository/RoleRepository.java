// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.repository;

import com.example.demo.model.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
   List<Role> findByNameRole(String nameRole);
}
