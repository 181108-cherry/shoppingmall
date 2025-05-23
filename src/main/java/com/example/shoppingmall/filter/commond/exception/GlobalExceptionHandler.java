package com.example.shoppingmall.filter.commond.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.shoppingmall.filter.commond.response.CommonResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<CommonResponse<Void>> handleBaseException(BaseException e) {
		ErrorCode code = e.getErrorCode();
		return ResponseEntity
			.status(code.getHttpStatus())
			.body(CommonResponse.fail(code.getHttpStatus().name(), code.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CommonResponse<Void>> handleUnexpected(Exception e) {
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(CommonResponse.fail("INTERNAL_SERVER_ERROR", "예상치 못한 오류가 발생했습니다."));

	}

}
