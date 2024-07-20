// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.PicRoom;
import com.example.demo.model.Room;
import com.example.demo.repository.PicRoomRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.Request.AddPicRoomRequest;
import com.example.demo.Request.UpdatePicRoomRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicRoomService {
   @Autowired
   private Cloudinary cloudinary;
   @Autowired
   private PicRoomRepository picRoomRepository;
   @Autowired
   private RoomRepository roomRepository;

   public PicRoomService() {
   }

   public List<PicRoom> getAllPicRooms() {
      return this.picRoomRepository.findAll();
   }

   public PicRoom getPicRoomById(Long id) {
      return (PicRoom)this.picRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PicHotel not found with id " + String.valueOf(id));
      });
   }

   public PicRoom savePicRoom(AddPicRoomRequest request) {
      PicRoom picroom = new PicRoom();
      picroom.setTenHinhAnhPhong(request.getTenHinhAnhPhong());
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Room not found with id " + String.valueOf(request.getIDPhong()));
      });
      picroom.setRoom(room);
      return (PicRoom)this.picRoomRepository.save(picroom);
   }

   public PicRoom updatePicRoom(Long id, UpdatePicRoomRequest request) {
      PicRoom picRoom = (PicRoom)this.picRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PicRoom not found with id " + String.valueOf(id));
      });
      picRoom.setTenHinhAnhPhong(request.getTenHinhAnhPhong());
      Room room = (Room)this.roomRepository.findById(request.getIDPhong()).orElseThrow(() -> {
         return new RuntimeException("Hotel not found with id " + String.valueOf(request.getIDPhong()));
      });
      picRoom.setRoom(room);
      return (PicRoom)this.picRoomRepository.save(picRoom);
   }

   public void deletePicRoom(Long id) {
      PicRoom picRoom = (PicRoom)this.picRoomRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PicRoom not found with id " + String.valueOf(id));
      });
      String publicId = this.getPublicIdFromUrl(picRoom.getTenHinhAnhPhong());

      try {
         this.cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
      } catch (Exception var5) {
         throw new RuntimeException("L\u1ed7i khi x\u00f3a h\u00ecnh \u1ea3nh t\u1eeb Cloudinary: " + var5.getMessage());
      }

      this.picRoomRepository.delete(picRoom);
   }

   private String getPublicIdFromUrl(String url) {
      String[] parts = url.split("/");
      String publicIdWithExtension = parts[parts.length - 1];
      return publicIdWithExtension.split("\\.")[0];
   }
}
