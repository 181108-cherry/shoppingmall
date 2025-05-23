package com.example.shoppingmall.filter.commond.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResponse<T> {
	private String status;
	private String message;
	private T data;

	public static <T>  CommonResponse<T> ok(String message, T data) {
		return new CommonResponse<>("OK", message, data);
	}

	public static <T> CommonResponse<T> fail(String  status, String message) {
		return new CommonResponse<>(status, message, null);
	}

}
