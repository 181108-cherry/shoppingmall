package com.example.shoppingmall.filter.search;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.filter.commond.response.CommonResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores/search")
public class StoreSearchController {

	private final StoreSearchService storeSearchService;

	@PostMapping
	public ResponseEntity<CommonResponse<List<StoreSearchResponseDto>>> search(
		@RequestBody StoreSearchCursorRequest request
	) {
		List<StoreSearchResponseDto> responseDto = storeSearchService.searchResponseDtos(request);
		return ResponseEntity.ok(CommonResponse.ok("검색결과", responseDto));
	}
}
