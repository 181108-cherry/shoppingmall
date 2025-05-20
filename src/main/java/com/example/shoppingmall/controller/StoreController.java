package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.StoreDto;
import com.example.shoppingmall.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // Create
    @PostMapping
    public ResponseEntity<StoreDto> createStore(@Valid @RequestBody StoreDto storeDto) {
        StoreDto created = storeService.createStore(storeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<StoreDto> updateStore(
            @PathVariable Long id,
            @Valid @RequestBody StoreDto storeDto) {
        StoreDto updated = storeService.updateStore(id, storeDto);
        return ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}
