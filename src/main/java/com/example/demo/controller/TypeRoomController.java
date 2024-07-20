// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.TypeRoom;
import com.example.demo.Request.AddTypeRoomRequest;
import com.example.demo.Request.UpdateTypeRoomRequest;
import com.example.demo.service.TypeRoomService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
@RequestMapping({"/typeroom"})
public class TypeRoomController {
   private final TypeRoomService typeRoomService;

   @GetMapping({"/all"})
   public List<TypeRoom> getAllTypeRooms() {
      return this.typeRoomService.getAllTypeRooms();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<TypeRoom> getTypeRoomById(@PathVariable Long id) {
      Optional<TypeRoom> typeRoom = this.typeRoomService.getTypeRoomById(id);
      return (ResponseEntity)typeRoom.map(ResponseEntity::ok).orElseGet(() -> {
         return ResponseEntity.notFound().build();
      });
   }

   @PostMapping({"/createTypeRoom"})
   public TypeRoom createTypeRoom(@RequestBody AddTypeRoomRequest newTypeRoomRequest) {
      return this.typeRoomService.createTypeRoom(newTypeRoomRequest);
   }

   @PutMapping({"/updateTypeRoom/{id}"})
   public ResponseEntity<Object> updateTypeRoom(@PathVariable Long id, @RequestBody UpdateTypeRoomRequest updatedTypeRoomRequest) {
      try {
         TypeRoom typeRoom = this.typeRoomService.updateTypeRoom(id, updatedTypeRoomRequest);
         return ResponseEntity.ok(typeRoom);
      } catch (ResourceNotFoundException var4) {
         return ResponseEntity.notFound().build();
      } catch (IllegalArgumentException var5) {
         return ResponseEntity.badRequest().body((Object)null);
      }
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<Void> deleteTypeRoom(@PathVariable Long id) {
      try {
         this.typeRoomService.deleteTypeRoom(id);
         return ResponseEntity.noContent().build();
      } catch (ResourceNotFoundException var3) {
         return ResponseEntity.notFound().build();
      }
   }

   public TypeRoomController(final TypeRoomService typeRoomService) {
      this.typeRoomService = typeRoomService;
   }
}
