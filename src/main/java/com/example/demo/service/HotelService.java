// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
   private HotelRepository hotelRepository;

   @Autowired
   public HotelService(HotelRepository hotelRepository) {
      this.hotelRepository = hotelRepository;
   }

   public List<Hotel> getAllHotels() {
      return this.hotelRepository.findAll();
   }

   public Optional<Hotel> getHotelById(String id) {
      return this.hotelRepository.findById(id);
   }

   public void deleteHotelById(String id) {
      this.hotelRepository.deleteById(id);
   }

   public Hotel saveHotel(Hotel hotel) {
      return (Hotel)this.hotelRepository.save(hotel);
   }
}
