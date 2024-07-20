// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.Room;
import com.example.demo.model.TypeRoom;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.TypeRoomRepository;
import com.example.demo.Request.AddRoomRequest;
import com.example.demo.Request.UpdateRoomRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
   @Autowired
   private RoomRepository roomRepository;
   @Autowired
   private TypeRoomRepository typeRoomRepository;

   public RoomService() {
   }

   public List<Room> getAllRooms() {
      return this.roomRepository.findAll();
   }

   public Optional<Room> getRoomById(Long id) {
      return this.roomRepository.findById(id);
   }

   public Room createRoom(AddRoomRequest roomRequest) {
      Room room = new Room();
      room.setTenphong(roomRequest.getTenphong());
      room.setLau(roomRequest.getLau());
      room.setDienTich(roomRequest.getDienTich());
      room.setTrangThai(roomRequest.isTrangThai());
      room.setMotaPhong(roomRequest.getMotaPhong());
      room.setGiaPhong(roomRequest.getGiaPhong());
      room.setSoLuongKhach(roomRequest.getSoLuongKhach());
      room.setHinhAnh(roomRequest.getHinhAnh());
      Long idLoaiPhong = roomRequest.getIDLoaiPhong();
      if (idLoaiPhong == null) {
         throw new IllegalArgumentException("IDLoaiPhong must not be null");
      } else {
         TypeRoom typeRoom = (TypeRoom)this.typeRoomRepository.findById(roomRequest.getIDLoaiPhong()).orElseThrow(() -> {
            return new RuntimeException("TypeRoom not found");
         });
         room.setTyperoom(typeRoom);
         return (Room)this.roomRepository.save(room);
      }
   }

   public Room updateRoom(Long id, UpdateRoomRequest roomDetails) {
      Room room = (Room)this.roomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("Room not found");
      });
      room.setTenphong(roomDetails.getTenphong());
      room.setLau(roomDetails.getLau());
      room.setDienTich(roomDetails.getDienTich());
      room.setTrangThai(roomDetails.isTrangThai());
      room.setMotaPhong(roomDetails.getMotaPhong());
      room.setGiaPhong(roomDetails.getGiaPhong());
      room.setSoLuongKhach(roomDetails.getSoLuongKhach());
      room.setHinhAnh(roomDetails.getHinhAnh());
      if (roomDetails.getIDLoaiPhong() != null) {
         TypeRoom typeRoom = (TypeRoom)this.typeRoomRepository.findById(roomDetails.getIDLoaiPhong()).orElseThrow(() -> {
            return new RuntimeException("TypeRoom not found");
         });
         room.setTyperoom(typeRoom);
      }

      return (Room)this.roomRepository.save(room);
   }

   public void deleteRoom(Long id) {
      this.roomRepository.deleteById(id);
   }
}
