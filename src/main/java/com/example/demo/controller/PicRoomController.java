// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.PicRoom;
import com.example.demo.Request.AddPicRoomRequest;
import com.example.demo.Request.UpdatePicRoomRequest;
import com.example.demo.service.PicRoomService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin({"*"})
@RequestMapping({"/imagesRoom"})
public class PicRoomController {
   @Autowired
   private Cloudinary cloudinary;
   @Autowired
   private PicRoomService picRoomService;

   public PicRoomController() {
   }

   @GetMapping({"/all"})
   public List<PicRoom> getAllPicRooms() {
      return this.picRoomService.getAllPicRooms();
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<PicRoom> getPicRoomById(@PathVariable Long id) {
      PicRoom picRoom = this.picRoomService.getPicRoomById(id);
      return ResponseEntity.ok(picRoom);
   }

   @PostMapping({"/upload"})
   public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("IDPhong") Long IDPhong) {
      try {
         if (IDPhong == null) {
            return ResponseEntity.status(400).body("idPhong is required");
         } else {
            String folderName = "room_images";
            Map<String, Object> params = ObjectUtils.asMap(new Object[]{"folder", folderName});
            Map uploadResult = this.cloudinary.uploader().upload(file.getBytes(), params);
            String imageUrl = (String)uploadResult.get("secure_url");
            AddPicRoomRequest request = new AddPicRoomRequest();
            request.setTenHinhAnhPhong(imageUrl);
            request.setIDPhong(IDPhong);
            PicRoom picRoom = this.picRoomService.savePicRoom(request);
            return ResponseEntity.ok("H\u00ecnh \u1ea3nh ph\u00f2ng \u0111\u00e3 \u0111\u01b0\u1ee3c t\u1ea3i l\u00ean th\u00e0nh c\u00f4ng: " + picRoom.getTenHinhAnhPhong());
         }
      } catch (Exception var9) {
         return ResponseEntity.status(500).body("L\u1ed7i khi t\u1ea3i l\u00ean h\u00ecnh \u1ea3nh ph\u00f2ng: " + var9.getMessage());
      }
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<String> updatePicRoom(@PathVariable Long id, @RequestParam("file") MultipartFile file, @RequestParam("IDPhong") Long IDPhong) {
      try {
         String folderName = "img_api";
         Map<String, Object> params = ObjectUtils.asMap(new Object[]{"folder", folderName});
         Map uploadResult = this.cloudinary.uploader().upload(file.getBytes(), params);
         String imageUrl = (String)uploadResult.get("secure_url");
         UpdatePicRoomRequest request = new UpdatePicRoomRequest();
         request.setTenHinhAnhPhong(imageUrl);
         request.setIDPhong(IDPhong);
         PicRoom updatedPicRoom = this.picRoomService.updatePicRoom(id, request);
         return ResponseEntity.ok("H\u00ecnh \u1ea3nh ph\u00f2ng \u0111\u00e3 \u0111\u01b0\u1ee3c c\u1eadp nh\u1eadt th\u00e0nh c\u00f4ng: " + updatedPicRoom.getTenHinhAnhPhong());
      } catch (Exception var10) {
         return ResponseEntity.status(500).body("L\u1ed7i khi c\u1eadp nh\u1eadt h\u00ecnh \u1ea3nh ph\u00f2ng: " + var10.getMessage());
      }
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<String> deletePicRoom(@PathVariable Long id) {
      try {
         this.picRoomService.deletePicRoom(id);
         return ResponseEntity.ok("H\u00ecnh \u1ea3nh ph\u00f2ng \u0111\u00e3 \u0111\u01b0\u1ee3c x\u00f3a th\u00e0nh c\u00f4ng.");
      } catch (Exception var3) {
         return ResponseEntity.status(500).body("L\u1ed7i khi x\u00f3a h\u00ecnh \u1ea3nh ph\u00f2ng: " + var3.getMessage());
      }
   }
}
