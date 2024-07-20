// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.model.TypeRoom;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.TypeRoomRepository;
import com.example.demo.Request.AddTypeRoomRequest;
import com.example.demo.Request.UpdateTypeRoomRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TypeRoomService {
   @Autowired
   private TypeRoomRepository typeRoomRepository;
   @Autowired
   private HotelRepository hotelRepository;

   public List<TypeRoom> getAllTypeRooms() {
      return this.typeRoomRepository.findAll();
   }

   public Optional<TypeRoom> getTypeRoomById(Long id) {
      return this.typeRoomRepository.findById(id);
   }

   public TypeRoom createTypeRoom(AddTypeRoomRequest request) {
      String idKhachSan = request.getIDKhachSan();
      if (idKhachSan == null) {
         throw new IllegalArgumentException("IDKhachSan cannot be null");
      } else {
         Hotel hotel = (Hotel)this.hotelRepository.findById(idKhachSan).orElseThrow(() -> {
            return new ResourceNotFoundException("Hotel not found with id " + idKhachSan);
         });
         TypeRoom typeRoom = new TypeRoom();
         typeRoom.setTenLoai(request.getTenLoai());
         typeRoom.setTienIchChung(request.getTienIchChung());
         typeRoom.setLoiIchChung(request.getLoiIchChung());
         typeRoom.setHotel(hotel);
         return this.typeRoomRepository.save(typeRoom);
      }
   }

   public TypeRoom updateTypeRoom(Long id, UpdateTypeRoomRequest updatedTypeRoomRequest) {
      return (TypeRoom)this.typeRoomRepository.findById(id).map((typeRoom) -> {
         typeRoom.setTenLoai(updatedTypeRoomRequest.getTenLoai());
         typeRoom.setTienIchChung(updatedTypeRoomRequest.getTienIchChung());
         typeRoom.setLoiIchChung(updatedTypeRoomRequest.getLoiIchChung());
         String idKhachSan = updatedTypeRoomRequest.getIdKhachSan();
         if (idKhachSan != null) {
            Hotel hotel = (Hotel)this.hotelRepository.findById(idKhachSan).orElseThrow(() -> {
               return new ResourceNotFoundException("Hotel not found with id " + idKhachSan);
            });
            typeRoom.setHotel(hotel);
         }

         return this.typeRoomRepository.save(typeRoom);
      }).orElseThrow(() -> {
         return new ResourceNotFoundException("TypeRoom not found with id " + String.valueOf(id));
      });
   }

   public void deleteTypeRoom(Long id) {
      this.typeRoomRepository.deleteById(id);
   }

   public TypeRoomService(final TypeRoomRepository typeRoomRepository, final HotelRepository hotelRepository) {
      this.typeRoomRepository = typeRoomRepository;
      this.hotelRepository = hotelRepository;
   }
}
