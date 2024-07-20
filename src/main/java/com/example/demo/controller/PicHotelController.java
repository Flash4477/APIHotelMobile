// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.PicHotel;
import com.example.demo.Request.AddPicHotelRequest;
import com.example.demo.Request.UpdatePicHotelRequest;
import com.example.demo.service.PicHotelService;
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
@RequestMapping({"/images"})
public class PicHotelController {
   @Autowired
   private Cloudinary cloudinary;
   @Autowired
   private PicHotelService picHotelService;

   public PicHotelController() {
   }

   @GetMapping({"/all"})
   public ResponseEntity<Object> getAllPicHotels() {
      try {
         List<PicHotel> picHotels = this.picHotelService.getAllPicHotels();
         return ResponseEntity.ok(picHotels);
      } catch (Exception var2) {
         return ResponseEntity.status(500).body((Object)null);
      }
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<Object> getPicHotelById(@PathVariable Long id) {
      try {
         PicHotel picHotel = this.picHotelService.getPicHotelById(id);
         return ResponseEntity.ok(picHotel);
      } catch (Exception var3) {
         return ResponseEntity.status(500).body((Object)null);
      }
   }

   @PostMapping({"/upload"})
   public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("IDKhachSan") String idkhachsan) {
      try {
         Map uploadResult = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
         String imgUrl = (String)uploadResult.get("secure_url");
         AddPicHotelRequest request = new AddPicHotelRequest();
         request.setTenHinhAnhKS(imgUrl);
         request.setIDKhachSan(idkhachsan);
         PicHotel picHotel = this.picHotelService.savePicHotel(request);
         return ResponseEntity.ok("H\u00ecnh \u1ea3nh kh\u00e1ch s\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c t\u1ea3i l\u00ean th\u00e0nh c\u00f4ng: " + picHotel.getTenHinhAnhKS());
      } catch (Exception var7) {
         return ResponseEntity.status(500).body("L\u1ed7i khi t\u1ea3i l\u00ean h\u00ecnh \u1ea3nh kh\u00e1ch s\u1ea1n: " + var7.getMessage());
      }
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<String> updatePicHotel(@PathVariable Long id, @RequestParam("file") MultipartFile file, @RequestParam("IDKhachSan") String idKhachSan) {
      try {
         Map uploadResult = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
         String imgUrl = (String)uploadResult.get("secure_url");
         UpdatePicHotelRequest request = new UpdatePicHotelRequest();
         request.setTenHinhAnhKS(imgUrl);
         request.setIDKhachSan(idKhachSan);
         PicHotel updatedPicHotel = this.picHotelService.updatePicHotel(id, request);
         return ResponseEntity.ok("H\u00ecnh \u1ea3nh kh\u00e1ch s\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c c\u1eadp nh\u1eadt th\u00e0nh c\u00f4ng: " + updatedPicHotel.getTenHinhAnhKS());
      } catch (Exception var8) {
         return ResponseEntity.status(500).body("L\u1ed7i khi c\u1eadp nh\u1eadt h\u00ecnh \u1ea3nh kh\u00e1ch s\u1ea1n: " + var8.getMessage());
      }
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<String> deletePicHotel(@PathVariable Long id) {
      try {
         this.picHotelService.deletePicHotel(id);
         return ResponseEntity.ok("H\u00ecnh \u1ea3nh kh\u00e1ch s\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c x\u00f3a th\u00e0nh c\u00f4ng.");
      } catch (Exception var3) {
         return ResponseEntity.status(500).body("L\u1ed7i khi x\u00f3a h\u00ecnh \u1ea3nh kh\u00e1ch s\u1ea1n: " + var3.getMessage());
      }
   }
}
