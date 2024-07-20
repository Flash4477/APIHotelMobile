// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.Hotel;
import com.example.demo.model.PicHotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.PicHotelRepository;
import com.example.demo.Request.AddPicHotelRequest;
import com.example.demo.Request.UpdatePicHotelRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicHotelService {
   @Autowired
   private Cloudinary cloudinary;
   @Autowired
   private PicHotelRepository picHotelRepository;
   @Autowired
   private HotelRepository hotelRepository;

   public PicHotelService() {
   }

   public List<PicHotel> getAllPicHotels() {
      return this.picHotelRepository.findAll();
   }

   public PicHotel getPicHotelById(Long id) {
      return (PicHotel)this.picHotelRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PicHotel not found with id " + String.valueOf(id));
      });
   }

   public PicHotel savePicHotel(AddPicHotelRequest request) {
      PicHotel picHotel = new PicHotel();
      picHotel.setTenHinhAnhKS(request.getTenHinhAnhKS());
      Hotel hotel = (Hotel)this.hotelRepository.findById(request.getIDKhachSan()).orElseThrow(() -> {
         return new RuntimeException("Hotel not found with id " + request.getIDKhachSan());
      });
      picHotel.setHotel(hotel);
      return (PicHotel)this.picHotelRepository.save(picHotel);
   }

   public PicHotel updatePicHotel(Long id, UpdatePicHotelRequest request) {
      PicHotel picHotel = (PicHotel)this.picHotelRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PicHotel not found with id " + String.valueOf(id));
      });
      picHotel.setTenHinhAnhKS(request.getTenHinhAnhKS());
      Hotel hotel = (Hotel)this.hotelRepository.findById(request.getIDKhachSan()).orElseThrow(() -> {
         return new RuntimeException("Hotel not found with id " + request.getIDKhachSan());
      });
      picHotel.setHotel(hotel);
      return (PicHotel)this.picHotelRepository.save(picHotel);
   }

   public void deletePicHotel(Long id) {
      PicHotel picHotel = (PicHotel)this.picHotelRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PicHotel not found with id " + String.valueOf(id));
      });
      String publicId = this.getPublicIdFromUrl(picHotel.getTenHinhAnhKS());

      try {
         this.cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
      } catch (Exception var5) {
         throw new RuntimeException("L\u1ed7i khi x\u00f3a h\u00ecnh \u1ea3nh t\u1eeb Cloudinary: " + var5.getMessage());
      }

      this.picHotelRepository.delete(picHotel);
   }

   private String getPublicIdFromUrl(String url) {
      String[] parts = url.split("/");
      String publicIdWithExtension = parts[parts.length - 1];
      return publicIdWithExtension.split("\\.")[0];
   }
}
