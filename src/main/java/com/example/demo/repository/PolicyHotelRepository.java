// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.repository;

import com.example.demo.model.PolicyHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyHotelRepository extends JpaRepository<PolicyHotel, Long> {
}
