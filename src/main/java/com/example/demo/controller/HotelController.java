// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping({"/hotels"})
public class HotelController {
   private final HotelService hotelService;

   @Autowired
   public HotelController(HotelService hotelService) {
      this.hotelService = hotelService;
   }

   @GetMapping({"/all"})
   public ResponseEntity<List<Hotel>> getAllHotels() {
      List<Hotel> hotels = this.hotelService.getAllHotels();
      return new ResponseEntity(hotels, HttpStatus.OK);
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<Hotel> getHotelById(@PathVariable("id") String id) {
      Optional<Hotel> hotel = this.hotelService.getHotelById(id);
      return (ResponseEntity)hotel.map((value) -> {
         return new ResponseEntity(value, HttpStatus.OK);
      }).orElseGet(() -> {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      });
   }

   @DeleteMapping({"delete/{id}"})
   public ResponseEntity<Void> deleteHotel(@PathVariable String id) {
      Optional<Hotel> hotel = this.hotelService.getHotelById(id);
      if (hotel.isPresent()) {
         this.hotelService.deleteHotelById(id);
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      } else {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
   }

   @PutMapping({"update/{id}"})
   public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hotelDetails) {
      Optional<Hotel> hotel = this.hotelService.getHotelById(id);
      if (hotel.isPresent()) {
         Hotel existingHotel = (Hotel)hotel.get();
         existingHotel.setTenKhachSan(hotelDetails.getTenKhachSan());
         existingHotel.setDiaChi(hotelDetails.getDiaChi());
         existingHotel.setHinhAnhKS(hotelDetails.getHinhAnhKS());
         existingHotel.setSDT(hotelDetails.getSDT());
         existingHotel.setDanhGia(hotelDetails.getDanhGia());
         existingHotel.setMoTa(hotelDetails.getMoTa());
         Hotel updatedHotel = this.hotelService.saveHotel(existingHotel);
         return new ResponseEntity(updatedHotel, HttpStatus.OK);
      } else {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
   }
}
