package com.example.shoppingmall.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.dto.StoreDto;
import com.example.shoppingmall.dto.StorePageableResponseDto;
import com.example.shoppingmall.dto.StoreSummaryResponseDto;
import com.example.shoppingmall.service.StoreService;

import jakarta.validation.Valid;

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

	@GetMapping("/search/top10")
	public ResponseEntity<List<StoreSummaryResponseDto>> getTop10Stores(
		@RequestParam int rating,
		@RequestParam String status
	) {
		List<StoreSummaryResponseDto> result = storeService.findTop10ByRatingAndStatus(rating, status);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/search/pageable")
	public ResponseEntity<StorePageableResponseDto> getStoresWithPaging(
		@RequestParam int rating,
		@RequestParam String status,
		@RequestParam int page,
		@RequestParam int size
	) {
		StorePageableResponseDto response = storeService.findStoresPaging(rating, status, page, size);
		return ResponseEntity.ok(response);
	}
}
