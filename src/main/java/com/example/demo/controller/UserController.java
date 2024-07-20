// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping({"/users"})
public class UserController {
   private final UserService userService;

   @Autowired
   public UserController(UserService userService) {
      this.userService = userService;
   }

   @GetMapping({"/all"})
   public ResponseEntity<List<User>> getAllUsers() {
      List<User> users = this.userService.getAllUsers();
      return new ResponseEntity(users, HttpStatus.OK);
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
      Optional<User> user = this.userService.getUserById(id);
      return (ResponseEntity)user.map((value) -> {
         return new ResponseEntity(value, HttpStatus.OK);
      }).orElseGet(() -> {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      });
   }

   @PostMapping({"/add"})
   public ResponseEntity<User> addUser(@RequestBody User user) {
      User newUser = this.userService.addUser(user);
      return new ResponseEntity(newUser, HttpStatus.CREATED);
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
      User updatedUser = this.userService.updateUser(id, user);
      return new ResponseEntity(updatedUser, HttpStatus.OK);
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
      this.userService.deleteUser(id);
      return new ResponseEntity(HttpStatus.OK);
   }
}
