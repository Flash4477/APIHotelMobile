// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.ConvenientHotel;
import com.example.demo.model.Hotel;
import com.example.demo.repository.ConvenientHotelRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.Request.AddConvenientHotelRequest;
import com.example.demo.Request.UpdateConvenientHotelRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvenientHotelService {
   @Autowired
   private ConvenientHotelRepository convenientHotelRepository;
   @Autowired
   private HotelRepository hotelRepository;

   public ConvenientHotelService() {
   }

   public List<ConvenientHotel> getAllConvenientHotels() {
      return this.convenientHotelRepository.findAll();
   }

   public ConvenientHotel getConvenientHotelById(Long id) {
      return (ConvenientHotel)this.convenientHotelRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("ConvenientHotel not found with id " + String.valueOf(id));
      });
   }

   public ConvenientHotel saveConvenientHotel(AddConvenientHotelRequest request) {
      ConvenientHotel convenientHotel = new ConvenientHotel();
      convenientHotel.setAmThuc(request.getAmThuc());
      convenientHotel.setTienNghiCongCong(request.getTienNghiCongCong());
      convenientHotel.setGiaiTriTheThao(request.getGiaiTriTheThao());
      convenientHotel.setTienIchChung(request.getTienIchChung());
      convenientHotel.setTreEmVaThuCung(request.getTreEmVaThuCung());
      convenientHotel.setPhuongTien(request.getPhuongTien());
      Hotel hotel = (Hotel)this.hotelRepository.findById(request.getIDKhachSan()).orElseThrow(() -> {
         return new RuntimeException("Hotel not found with id " + request.getIDKhachSan());
      });
      convenientHotel.setHotel(hotel);
      return (ConvenientHotel)this.convenientHotelRepository.save(convenientHotel);
   }

   public ConvenientHotel updateConvenientHotel(Long id, UpdateConvenientHotelRequest request) {
      ConvenientHotel convenientHotel = (ConvenientHotel)this.convenientHotelRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("ConvenientHotel not found with id " + String.valueOf(id));
      });
      convenientHotel.setAmThuc(request.getAmThuc());
      convenientHotel.setTienNghiCongCong(request.getTienNghiCongCong());
      convenientHotel.setGiaiTriTheThao(request.getGiaiTriTheThao());
      convenientHotel.setTienIchChung(request.getTienIchChung());
      convenientHotel.setTreEmVaThuCung(request.getTreEmVaThuCung());
      convenientHotel.setPhuongTien(request.getPhuongTien());
      Hotel hotel = (Hotel)this.hotelRepository.findById(request.getIDKhachSan()).orElseThrow(() -> {
         return new RuntimeException("Hotel not found with id " + request.getIDKhachSan());
      });
      convenientHotel.setHotel(hotel);
      return (ConvenientHotel)this.convenientHotelRepository.save(convenientHotel);
   }

   public void deleteConvenientHotel(Long id) {
      ConvenientHotel convenientHotel = (ConvenientHotel)this.convenientHotelRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("ConvenientHotel not found with id " + String.valueOf(id));
      });
      this.convenientHotelRepository.delete(convenientHotel);
   }
}
