package com.example.shoppingmall.filter.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.filter.commond.response.CommonResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreQueryController {
	private final StoreQueryService storeQueryService;

	@GetMapping("/{id}")
	public ResponseEntity<CommonResponse<StoreQueryDto>> getStoreById(@PathVariable Long id) {
		StoreQueryDto dto = storeQueryService.findStoreById(id);
		return ResponseEntity.ok(CommonResponse.ok("가게 조회 성공", dto));
	}
}
