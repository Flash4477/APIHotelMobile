// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.ConvenientRoom;
import com.example.demo.model.Room;
import com.example.demo.repository.ConvenientRoomRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.Request.AddConvenientRoomRequest;
import com.example.demo.Request.UpdateConvenientRoomRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvenientRoomService {
   @Autowired
   private ConvenientRoomRepository convenientRoomRepository;
   @Autowired
   private RoomRepository roomRepository;

   public ConvenientRoomService() {
   }

   public List<ConvenientRoom> getAllConvenientRooms() {
      return this.convenientRoomRepository.findAll();
   }

   public ConvenientRoom getConvenientRoomById(Long id) {
      return (ConvenientRoom)this.convenientRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("ConvenientRoom not found with id " + String.valueOf(id));
      });
   }

   public ConvenientRoom saveConvenientRoom(AddConvenientRoomRequest request) {
      ConvenientRoom convenientRoom = new ConvenientRoom();
      convenientRoom.setTienNghiRiengTu(request.getTienNghiRiengTu());
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
      });
      convenientRoom.setRoom(room);
      return (ConvenientRoom)this.convenientRoomRepository.save(convenientRoom);
   }

   public ConvenientRoom updateConvenientRoom(Long id, UpdateConvenientRoomRequest request) {
      ConvenientRoom convenientRoom = (ConvenientRoom)this.convenientRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("ConvenientRoom not found with id " + String.valueOf(id));
      });
      convenientRoom.setTienNghiRiengTu(request.getTienNghiRiengTu());
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
      });
      convenientRoom.setRoom(room);
      return (ConvenientRoom)this.convenientRoomRepository.save(convenientRoom);
   }

   public void deleteConvenientRoom(Long id) {
      ConvenientRoom convenientRoom = (ConvenientRoom)this.convenientRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("ConvenientRoom not found with id " + String.valueOf(id));
      });
      this.convenientRoomRepository.delete(convenientRoom);
   }
}
