// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.controller;

import com.example.demo.model.PolicyHotel;
import com.example.demo.Request.AddPolicyRequest;
import com.example.demo.Request.UpdatePolicyRequest;
import com.example.demo.service.PolicyHotelService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping({"/policy"})
public class PolicyController {
   @Autowired
   private PolicyHotelService policyService;

   public PolicyController() {
   }

   @GetMapping({"/all"})
   public ResponseEntity<List<PolicyHotel>> getAllPolicies() {
      List<PolicyHotel> policies = this.policyService.findAllPolicies();
      return ResponseEntity.ok(policies);
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<PolicyHotel> getPolicyById(@PathVariable Long id) {
      Optional<PolicyHotel> policy = this.policyService.findPolicyById(id);
      return (ResponseEntity)policy.map(ResponseEntity::ok).orElseGet(() -> {
         return ResponseEntity.notFound().build();
      });
   }

   @PostMapping({"/createPolicy"})
   public ResponseEntity<PolicyHotel> createPolicy(@RequestBody AddPolicyRequest request) {
      PolicyHotel createdPolicy = this.policyService.savePolicy(request);
      return ResponseEntity.ok(createdPolicy);
   }

   @PutMapping({"/updatePolicy/{id}"})
   public ResponseEntity<PolicyHotel> updatePolicy(@PathVariable Long id, @RequestBody UpdatePolicyRequest request) {
      PolicyHotel updatedPolicy = this.policyService.updatePolicy(id, request);
      return ResponseEntity.ok(updatedPolicy);
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
      this.policyService.deletePolicy(id);
      return ResponseEntity.noContent().build();
   }
}
