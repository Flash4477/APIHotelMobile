// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.Request.AddRoomRequest;
import com.example.demo.Request.UpdateRoomRequest;
import com.example.demo.service.RoomService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping({"/room"})
public class RoomController {
   @Autowired
   private RoomService roomService;

   public RoomController() {
   }

   @GetMapping({"/all"})
   public List<Room> getAllRooms() {
      return this.roomService.getAllRooms();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
      Optional<Room> room = this.roomService.getRoomById(id);
      return room.isPresent() ? ResponseEntity.ok((Room)room.get()) : ResponseEntity.notFound().build();
   }

   @PostMapping({"/createroom"})
   public ResponseEntity<Room> createRoom(@RequestBody AddRoomRequest roomRequest) {
      Room newRoom = this.roomService.createRoom(roomRequest);
      System.out.println(newRoom);
      return ResponseEntity.ok(newRoom);
   }

   @PutMapping({"/updateRoom/{id}"})
   public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody UpdateRoomRequest roomDetails) {
      Room updatedRoom = this.roomService.updateRoom(id, roomDetails);
      return ResponseEntity.ok(updatedRoom);
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
      this.roomService.deleteRoom(id);
      return ResponseEntity.noContent().build();
   }
}
