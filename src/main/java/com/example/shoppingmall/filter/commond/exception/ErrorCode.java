package com.example.shoppingmall.filter.commond.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// rating filter Error Code
	INVALID_RATING_RANGE(HttpStatus.BAD_REQUEST, "전체 평가 점수는 0에서 3 사이의 정수여야 합니다."),
	RATING_REQUIRED(HttpStatus.BAD_REQUEST, "전체 평가 점수 입력은 필수입니다."),

	// top 10,pageable Error Code
	INVAILD_RATING(HttpStatus.BAD_REQUEST, "rating은 1~5 사이여야합니다."),
	INVAILD_STATUS(HttpStatus.BAD_REQUEST, "유효하지 않은 status 입니다."),
	INVAILD_PAGE(HttpStatus.BAD_REQUEST, "page는 0 이상이어야합니다."),
	INVALID_PAGE_SIZE(HttpStatus.BAD_REQUEST, "size는 1~100 사이 입니다."),

	// Error Code
	CSV_LOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "CSV 파일을 찾을 수 없습니다"),
	INVAILD_REQUEST(HttpStatus.BAD_REQUEST, "요청 형식이 잘목 되었습니다"),
	STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "조건에 해당하는 가게를 찾을 수 없습니다."),
	// CUD Error Code
	INVALID_STORE_REQUEST(HttpStatus.BAD_REQUEST, "가게 생성 필수 요구사항이 비어있습니다"),
	DUPLICATE_STORE(HttpStatus.CONFLICT, "이미 등록된 가게입니다."),
	STORE_DELETE_NOT_FOUND(HttpStatus.NOT_FOUND, "삭제하려는 가게가 존재하지 않습니다");

	private final HttpStatus httpStatus;
	private final String message;
}
