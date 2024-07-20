// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   private CustomUserDetailService customUserDetailService;

   public SecurityConfig() {
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      ((HttpSecurity)((HttpSecurity)httpSecurity.csrf().disable()).exceptionHandling().and()).authorizeHttpRequests((authorize) -> {
         ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)authorize.requestMatchers(new String[]{"/api/auth/**"})).permitAll().anyRequest()).permitAll();
      }).httpBasic();
      return (SecurityFilterChain)httpSecurity.build();
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration auConfiguration) throws Exception {
      return auConfiguration.getAuthenticationManager();
   }

   @Bean
   PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
}
