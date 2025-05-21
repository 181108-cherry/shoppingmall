package com.example.shoppingmall.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageableStoreResponseDto {

	private List<StoreSummaryResponseDto> data;
	private int page;
	private int size;
}
