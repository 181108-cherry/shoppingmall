package com.example.shoppingmall.filter.commond.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	// Error Code
	CSV_LOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "CSV 파일을 찾을 수 없습니다"),
	INVAILD_REQUEST(HttpStatus.BAD_REQUEST, "요청 형식이 잘목 되었습니다"),
	STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "조건에 해당하는 가게를 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
