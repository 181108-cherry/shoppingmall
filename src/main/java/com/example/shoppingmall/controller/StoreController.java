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
import com.example.shoppingmall.dto.StoreFilterResponse;
import com.example.shoppingmall.dto.StorePageableResponseDto;
import com.example.shoppingmall.dto.StoreSummaryResponseDto;
import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.filter.commond.exception.BaseException;
import com.example.shoppingmall.filter.commond.exception.ErrorCode;
import com.example.shoppingmall.service.StoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stores")
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
		@RequestParam(name = "rating") int rating,
		@RequestParam(name = "status") String status
	) {

		if (rating < 1 || rating > 5) {
			throw new BaseException(ErrorCode.INVAILD_RATING);
		}
		if (status == null || status.isEmpty()) {
			throw new BaseException(ErrorCode.INVAILD_STATUS);
		}

		List<StoreSummaryResponseDto> result = storeService.findTop10ByRatingAndStatus(rating, status);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/search/pageable")
	public ResponseEntity<StorePageableResponseDto> getStoresWithPaging(
		@RequestParam(name = "rating") int rating,
		@RequestParam(name = "status") String status,
		@RequestParam(name = "page") int page,
		@RequestParam(name = "size") int size
	) {

		if (rating < 1 || rating > 5) {
			throw new BaseException(ErrorCode.INVAILD_RATING);
		}
		if (status == null || status.isEmpty()) {
			throw new BaseException(ErrorCode.INVAILD_STATUS);
		}

		if (page < 0) {
			throw new BaseException(ErrorCode.INVAILD_PAGE);
		}

		if (size < 1 || size > 100) {
			throw new BaseException(ErrorCode.INVALID_PAGE_SIZE);
		}

		StorePageableResponseDto response = storeService.findStoresPaging(rating, status, page, size);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/filter")
	public ResponseEntity<?> getStoresByStatus(
		@RequestParam String status  // 필수 status 파라미터
	) {
		// status 값 검증: 유효하지 않은 값은 예외 처리
		List<String> validStatuses = List.of("사이트운영중단", "휴업중", "광고용(홍보용)", "등록정보불일치",
			"사이트폐쇄", "영업중", "확인안됨");

		if (status == null || status.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("status 입력은 필수입니다.");
		}

		if (!validStatuses.contains(status)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("status 값이 올바르지 않습니다.");
		}

		// 데이터를 조회하여 응답
		List<StoreSummaryResponseDto> result = storeService.findStoresByStatus(status);

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("조회 결과가 없습니다.");
		}
		return ResponseEntity.ok(new StoreFilterResponse(result));  // 성공적인 조회 결과 반환
	}

	@GetMapping("/search-by-rating")
	public List<StoreEntity> searchStoresByRating(@RequestParam("rating") int rating) {
		return storeService.rating(rating);
	}

}
