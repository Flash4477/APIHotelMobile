// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Hotel;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.Request.AddCommentRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
   @Autowired
   private CommentRepository commentRepository;
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private HotelRepository hotelRepository;

   public CommentService() {
   }

   public Optional<Comment> getCommentById(Long id) {
      return this.commentRepository.findById(id);
   }

   public List<Comment> getAllComments() {
      return this.commentRepository.findAll();
   }

   public Comment createComment(AddCommentRequest commentRequest) {
      Comment comment = new Comment();
      comment.setNoiDung(commentRequest.getNoiDung());
      comment.setDanhGia(commentRequest.getDanhGia());
      comment.setSoLuongThich(0);
      Long idKhachHang = commentRequest.getIDKhachHang();
      if (idKhachHang == null) {
         throw new IllegalArgumentException("IDKhachHang must not be null");
      } else {
         User khachHang = (User)this.userRepository.findById(idKhachHang).orElseThrow(() -> {
            return new RuntimeException("KhachHang not found");
         });
         comment.setUser(khachHang);
         String idKhachSan = commentRequest.getIDKhachSan();
         if (idKhachSan == null) {
            throw new IllegalArgumentException("IDKhachSan must not be null");
         } else {
            Hotel hotel = (Hotel)this.hotelRepository.findById(idKhachSan).orElseThrow(() -> {
               return new RuntimeException("KhachSan not found");
            });
            comment.setHotel(hotel);
            return (Comment)this.commentRepository.save(comment);
         }
      }
   }

   public void deleteComment(Long id) {
      this.commentRepository.deleteById(id);
   }
}
