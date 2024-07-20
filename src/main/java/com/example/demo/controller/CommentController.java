// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.Request.AddCommentRequest;
import com.example.demo.service.CommentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping({"/comment"})
public class CommentController {
   @Autowired
   private CommentService commentService;

   public CommentController() {
   }

   @PostMapping({"/createComment"})
   public ResponseEntity<Object> createComment(@RequestBody AddCommentRequest commentRequest) {
      try {
         Comment newComment = this.commentService.createComment(commentRequest);
         return ResponseEntity.ok(newComment);
      } catch (Exception var3) {
         return ResponseEntity.badRequest().body((Object)null);
      }
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
      Optional<Comment> comment = this.commentService.getCommentById(id);
      return (ResponseEntity)comment.map(ResponseEntity::ok).orElseGet(() -> {
         return ResponseEntity.notFound().build();
      });
   }

   @GetMapping({"/all"})
   public ResponseEntity<List<Comment>> getAllComments() {
      List<Comment> comments = this.commentService.getAllComments();
      return ResponseEntity.ok(comments);
   }

   @DeleteMapping({"/{id}"})
   public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
      try {
         this.commentService.deleteComment(id);
         return ResponseEntity.noContent().build();
      } catch (Exception var3) {
         return ResponseEntity.badRequest().build();
      }
   }
}
