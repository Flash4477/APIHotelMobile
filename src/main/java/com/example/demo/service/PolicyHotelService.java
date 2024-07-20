// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.model.PolicyHotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.PolicyHotelRepository;
import com.example.demo.Request.AddPolicyRequest;
import com.example.demo.Request.UpdatePolicyRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyHotelService {
   @Autowired
   private PolicyHotelRepository policyHotelRepository;
   @Autowired
   private HotelRepository hotelRepository;

   public PolicyHotelService() {
   }

   public List<PolicyHotel> findAllPolicies() {
      return this.policyHotelRepository.findAll();
   }

   public Optional<PolicyHotel> findPolicyById(Long id) {
      return this.policyHotelRepository.findById(id);
   }

   public PolicyHotel savePolicy(AddPolicyRequest request) {
      PolicyHotel policyHotel = new PolicyHotel();
      policyHotel.setGioNhanPhong(request.getGioNhanPhong());
      policyHotel.setGioTraPhong(request.getGioTraPhong());
      policyHotel.setNoiDung(request.getNoiDung());
      Optional<Hotel> hotel = this.hotelRepository.findById(request.getIDKhachSan());
      if (hotel.isPresent()) {
         policyHotel.setHotel((Hotel)hotel.get());
         return (PolicyHotel)this.policyHotelRepository.save(policyHotel);
      } else {
         throw new RuntimeException("Hotel not found with id " + request.getIDKhachSan());
      }
   }

   public PolicyHotel updatePolicy(Long id, UpdatePolicyRequest request) {
      Optional<PolicyHotel> existingPolicy = this.policyHotelRepository.findById(id);
      if (existingPolicy.isPresent()) {
         PolicyHotel policyToUpdate = (PolicyHotel)existingPolicy.get();
         policyToUpdate.setGioNhanPhong(request.getGioNhanPhong());
         policyToUpdate.setGioTraPhong(request.getGioTraPhong());
         policyToUpdate.setNoiDung(request.getNoiDung());
         Optional<Hotel> hotel = this.hotelRepository.findById(request.getIDKhachSan());
         if (hotel.isPresent()) {
            policyToUpdate.setHotel((Hotel)hotel.get());
            return (PolicyHotel)this.policyHotelRepository.save(policyToUpdate);
         } else {
            throw new RuntimeException("Hotel not found with id " + request.getIDKhachSan());
         }
      } else {
         throw new RuntimeException("Policy not found with id " + String.valueOf(id));
      }
   }

   public void deletePolicy(Long id) {
      this.policyHotelRepository.deleteById(id);
   }
}
