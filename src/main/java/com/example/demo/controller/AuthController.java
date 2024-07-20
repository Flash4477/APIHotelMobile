// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Request.RequestRegister;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"auth/"})
public class AuthController {
   private AuthenticationManager authenticationManager;
   private UserRepository userRepository;
   private RoleRepository roleRepository;
   private PasswordEncoder passwordEncoder;

   @PostMapping({"register"})
   public ResponseEntity<String> Register(@RequestBody RequestRegister requestRegister) {
      if (this.userRepository.existsByEmail(requestRegister.getEmail())) {
         return new ResponseEntity("Email is taken", HttpStatus.BAD_REQUEST);
      } else if (!requestRegister.getPassword().equals(requestRegister.getConfirmPass())) {
         return new ResponseEntity("Password and Confirm Password do not match", HttpStatus.BAD_REQUEST);
      } else {
         User user = new User();
         user.setTenKhachHang(requestRegister.getTenKhachHang());
         user.setEmail(requestRegister.getEmail());
         user.setPassword(this.passwordEncoder.encode(requestRegister.getPassword()));
         Role roles = (Role)this.roleRepository.findByNameRole("USER").get(0);
         user.setRoles(Collections.singletonList(roles));
         this.userRepository.save(user);
         return new ResponseEntity("User registered success", HttpStatus.OK);
      }
   }

   @PostMapping({"login"})
   public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
      try {
         Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
         SecurityContextHolder.getContext().setAuthentication(authentication);
         return new ResponseEntity("User Signed Success", HttpStatus.OK);
      } catch (Exception var3) {
         return new ResponseEntity("Invalid email or password", HttpStatus.UNAUTHORIZED);
      }
   }

   public AuthController(final AuthenticationManager authenticationManager, final UserRepository userRepository, final RoleRepository roleRepository, final PasswordEncoder passwordEncoder) {
      this.authenticationManager = authenticationManager;
      this.userRepository = userRepository;
      this.roleRepository = roleRepository;
      this.passwordEncoder = passwordEncoder;
   }
}
