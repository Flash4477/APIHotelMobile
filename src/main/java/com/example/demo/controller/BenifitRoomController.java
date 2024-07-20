// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.BenifitRoom;
import com.example.demo.Request.AddBenifitRoomRequest;
import com.example.demo.Request.UpdateBenifitRoomRequest;
import com.example.demo.service.BenifitRoomService;
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
@RequestMapping({"/benifitRooms"})
public class BenifitRoomController {
   @Autowired
   private BenifitRoomService benifitRoomService;

   public BenifitRoomController() {
   }

   @GetMapping({"/all"})
   public List<BenifitRoom> getAllBenifitRooms() {
      return this.benifitRoomService.getAllBenifitRooms();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<BenifitRoom> getBenifitRoomById(@PathVariable Long id) {
      BenifitRoom benifitRoom = this.benifitRoomService.getBenifitRoomById(id);
      return ResponseEntity.ok(benifitRoom);
   }

   @PostMapping({"/create"})
   public ResponseEntity<String> addBenifitRoom(@RequestBody AddBenifitRoomRequest request) {
      try {
         BenifitRoom benifitRoom = this.benifitRoomService.saveBenifitRoom(request);
         return ResponseEntity.ok("BenifitRoom has been added successfully: " + benifitRoom.getLoiIchRiengTu());
      } catch (Exception var3) {
         return ResponseEntity.status(500).body("Error adding BenifitRoom: " + var3.getMessage());
      }
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<String> updateBenifitRoom(@PathVariable Long id, @RequestBody UpdateBenifitRoomRequest request) {
      try {
         BenifitRoom updatedBenifitRoom = this.benifitRoomService.updateBenifitRoom(id, request);
         return ResponseEntity.ok("BenifitRoom has been updated successfully: " + updatedBenifitRoom.getLoiIchRiengTu());
      } catch (Exception var4) {
         return ResponseEntity.status(500).body("Error updating BenifitRoom: " + var4.getMessage());
      }
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<String> deleteBenifitRoom(@PathVariable Long id) {
      try {
         this.benifitRoomService.deleteBenifitRoom(id);
         return ResponseEntity.ok("BenifitRoom has been deleted successfully.");
      } catch (Exception var3) {
         return ResponseEntity.status(500).body("Error deleting BenifitRoom: " + var3.getMessage());
      }
   }
}
