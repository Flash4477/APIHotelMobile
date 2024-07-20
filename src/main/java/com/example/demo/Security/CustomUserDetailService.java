// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
   private UserRepository userRepository;

   @Autowired
   public CustomUserDetailService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      User user = (User)this.userRepository.findByEmail(email).orElseThrow(() -> {
         return new UsernameNotFoundException("User not found with email: " + email);
      });
      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), this.mapRolesToAuthorities(user.getRoles()));
   }

   private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
      return (Collection)roles.stream().map((role) -> {
         return new SimpleGrantedAuthority(role.getNameRole());
      }).collect(Collectors.toList());
   }
}
