package com.example.shoppingmall.filter.csv;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.filter.commond.exception.BaseException;
import com.example.shoppingmall.filter.commond.exception.ErrorCode;
import com.example.shoppingmall.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CsvLoader {
	private final StoreRepository storeRepository;

	public void loadCsvAndInsertToDb() {
		try {
			// CSV 파일 로딩, UTF-8로 읽기
			ClassPathResource resource = new ClassPathResource("shoppingmall.csv");
			Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);

			// CSV 파싱 - apache Commons CSV 라이브러리
			CSVParser parser = CSVFormat.DEFAULT // ','로 구분
				.withFirstRecordAsHeader() // 첫 줄 헤더
				.withIgnoreEmptyLines()
				.withTrim()
				.withQuote('"') // "" 값을 하나의 필드로 인식
				.parse(reader);

			List<StoreEntity> storeList = new ArrayList<>();

			for (CSVRecord record : parser) {
				// 한줄에 32개씩
				String[] colums = new String[32];

				// 빈값 = 정보없음 처리
				for (int i = 0; i < colums.length; i++) {
					String value = record.get(i);
					colums[i] = (value == null || value.isBlank()) ? "정보없음" : value.trim();
				}

				// 엔터티 변환 후 저장
				storeList.add(StoreCsvDto.fromCsv(colums).toEntity());
			}

			// DB에 저장
			storeRepository.deleteAllInBatch(); // 기존데이터 초기화
			storeRepository.saveAll(storeList); // 새 데이터 저장

			System.out.println("총 저장 수" + storeList.size());

		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.CSV_LOAD_FAIL);
		}

	}
}

