package com.example.shoppingmall.filter.csv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.filter.commond.exception.BaseException;
import com.example.shoppingmall.filter.commond.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CsvService {

	private final CsvLoader csvLoader;
	public void uploadCsvToDb() {
		csvLoader.loadCsvAndInsertToDb();
	}

}
