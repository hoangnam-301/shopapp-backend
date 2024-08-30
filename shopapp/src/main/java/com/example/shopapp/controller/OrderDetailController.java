package com.example.shopapp.controller;

import com.example.shopapp.dtos.CategoryDTO;
import com.example.shopapp.dtos.OrderDTO;
import com.example.shopapp.dtos.OrderDetailDTO;
import com.example.shopapp.dtos.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/v1/order_details")

public class OrderDetailController {
    @PostMapping("")
    public ResponseEntity<?> createOrderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTODTODTO,
            BindingResult result
    ) {
        try{
            if(result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok("Create order detail successfully");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderDetail(
            @Valid
            @PathVariable("id")
            Long id) {
        try{
            return ResponseEntity.ok("Get oder detail with id = " + id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("order/{orderId}")
    public ResponseEntity<String> getOrderDetails(
            @Valid
            @PathVariable("orderId")
            Long orderId) {
        try{
            return ResponseEntity.ok("Get order details with orderId = " + orderId);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(
            @Valid @PathVariable Long id,
            @Valid @RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.ok("Order detail has updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@Valid @PathVariable Long id) {
        return ResponseEntity.ok("Order has deleted successfully");
    }
}
