package com.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StoreFilterResponse {

    private List<StoreSummaryResponseDto> data;

}
