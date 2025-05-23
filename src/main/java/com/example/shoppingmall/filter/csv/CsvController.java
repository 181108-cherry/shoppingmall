package com.example.shoppingmall.filter.csv;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.filter.commond.response.CommonResponse;
import com.example.shoppingmall.filter.commond.response.ResponseCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/collection")
public class CsvController {

	private final CsvService csvService;

	@PostMapping
	public CommonResponse<Void> uploadCsv() {

		csvService.uploadCsvToDb();
		return CommonResponse.ok(ResponseCode.CSV_UPLOAD_SUCCESS.getMessage(), null);
	}
}
