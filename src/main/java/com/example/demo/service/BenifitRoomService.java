// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.BenifitRoom;
import com.example.demo.model.Room;
import com.example.demo.repository.BenifitRoomRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.Request.AddBenifitRoomRequest;
import com.example.demo.Request.UpdateBenifitRoomRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenifitRoomService {
   @Autowired
   private BenifitRoomRepository benifitRoomRepository;
   @Autowired
   private RoomRepository roomRepository;

   public BenifitRoomService() {
   }

   public List<BenifitRoom> getAllBenifitRooms() {
      return this.benifitRoomRepository.findAll();
   }

   public BenifitRoom getBenifitRoomById(Long id) {
      return (BenifitRoom)this.benifitRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("BenifitRoom not found with id " + String.valueOf(id));
      });
   }

   public BenifitRoom saveBenifitRoom(AddBenifitRoomRequest request) {
      BenifitRoom benifitRoom = new BenifitRoom();
      benifitRoom.setLoiIchRiengTu(request.getLoiIchRiengTu());
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
      });
      benifitRoom.setRoom(room);
      return (BenifitRoom)this.benifitRoomRepository.save(benifitRoom);
   }

   public BenifitRoom updateBenifitRoom(Long id, UpdateBenifitRoomRequest request) {
      BenifitRoom benifitRoom = (BenifitRoom)this.benifitRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("BenifitRoom not found with id " + String.valueOf(id));
      });
      benifitRoom.setLoiIchRiengTu(request.getLoiIchRiengTu());
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
      });
      benifitRoom.setRoom(room);
      return (BenifitRoom)this.benifitRoomRepository.save(benifitRoom);
   }

   public void deleteBenifitRoom(Long id) {
      BenifitRoom benifitRoom = (BenifitRoom)this.benifitRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("BenifitRoom not found with id " + String.valueOf(id));
      });
      this.benifitRoomRepository.delete(benifitRoom);
   }
}
