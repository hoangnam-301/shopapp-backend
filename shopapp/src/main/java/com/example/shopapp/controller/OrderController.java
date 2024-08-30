package com.example.shopapp.controller;

import com.example.shopapp.dtos.CategoryDTO;
import com.example.shopapp.dtos.OrderDTO;
import com.example.shopapp.dtos.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/v1/orders")

public class OrderController {
    @PostMapping("")
    public ResponseEntity<?> createOrder(
            @Valid @RequestBody OrderDTO orderDTO,
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
            return ResponseEntity.ok("Create order successfully");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<String> getOrders(
            @Valid
            @PathVariable("user_id")
            Long userId) {
        try{
            return ResponseEntity.ok("Return order's list from user_id");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(
            @Valid @PathVariable Long id,
            @Valid @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok("Order has updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@Valid @PathVariable Long id) {
        return ResponseEntity.ok("Order has deleted successfully");
    }
}
