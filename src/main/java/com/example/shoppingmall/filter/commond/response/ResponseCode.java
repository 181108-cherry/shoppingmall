package com.example.shoppingmall.filter.commond.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
	// success code
	CSV_UPLOAD_SUCCESS("OK", "CSV 저장 완료"),
	STORE_FOUND("OK", "가게 조회 성공");

	private final String status;
	private final String message;

}
