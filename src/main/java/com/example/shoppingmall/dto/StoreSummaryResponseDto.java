package com.example.shoppingmall.dto;

import java.time.LocalDate;

import com.example.shoppingmall.entity.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreSummaryResponseDto {
	private Long id;
	private String companyName;
	private String storeName;
	private String domain;
	private String telephoneNumber;
	private int rating;
	private String status;
	private LocalDate monitoringDate;

	public static StoreSummaryResponseDto from(StoreEntity entity) {
		return new StoreSummaryResponseDto(
			entity.getId(),
			entity.getCompanyName(),
			entity.getShoppingmallName(),
			entity.getDomain(),
			entity.getTelephoneNumber(),
			entity.getRating(),
			entity.getStatus(),
			entity.getMonitoringDate()
		);
	}
}
