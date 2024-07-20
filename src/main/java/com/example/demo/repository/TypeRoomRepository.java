// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.repository;

import com.example.demo.model.TypeRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRoomRepository extends JpaRepository<TypeRoom, Long> {
   List<TypeRoom> findAll();

   Optional<TypeRoom> findById(Long id);

   TypeRoom save(TypeRoom typeRoom);

   void deleteById(Long id);
}
