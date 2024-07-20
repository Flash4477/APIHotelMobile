// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.ConvenientHotel;
import com.example.demo.Request.AddConvenientHotelRequest;
import com.example.demo.Request.UpdateConvenientHotelRequest;
import com.example.demo.service.ConvenientHotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping({"/convenientHotels"})
public class ConvenientHotelController {
   @Autowired
   private ConvenientHotelService convenientHotelService;

   public ConvenientHotelController() {
   }

   @GetMapping({"/all"})
   public List<ConvenientHotel> getAllConvenientHotels() {
      return this.convenientHotelService.getAllConvenientHotels();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<ConvenientHotel> getConvenientHotelById(@PathVariable Long id) {
      ConvenientHotel convenientHotel = this.convenientHotelService.getConvenientHotelById(id);
      return ResponseEntity.ok(convenientHotel);
   }

   @PostMapping({"/createConvenientHotel"})
   public ResponseEntity<String> addConvenientHotel(@RequestBody AddConvenientHotelRequest request) {
      try {
         this.convenientHotelService.saveConvenientHotel(request);
         return ResponseEntity.ok("ConvenientHotel has been added successfully: ");
      } catch (Exception var3) {
         return ResponseEntity.status(500).body("Error adding ConvenientHotel: " + var3.getMessage());
      }
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<String> updateConvenientHotel(@PathVariable Long id, @RequestBody UpdateConvenientHotelRequest request) {
      try {
         ConvenientHotel updatedConvenientHotel = this.convenientHotelService.updateConvenientHotel(id, request);
         return ResponseEntity.ok("ConvenientHotel has been updated successfully: " + String.valueOf(updatedConvenientHotel));
      } catch (Exception var4) {
         return ResponseEntity.status(500).body("Error updating ConvenientHotel: " + var4.getMessage());
      }
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<String> deleteConvenientHotel(@PathVariable Long id) {
      try {
         this.convenientHotelService.deleteConvenientHotel(id);
         return ResponseEntity.ok("ConvenientHotel has been deleted successfully.");
      } catch (Exception var3) {
         return ResponseEntity.status(500).body("Error deleting ConvenientHotel: " + var3.getMessage());
      }
   }
}
