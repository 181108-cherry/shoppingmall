package com.example.shoppingmall.filter.csv;

import java.time.LocalDate;
import java.util.Map;

import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

public class CsvDataSubStr {

	// 필드 최대 길이 제한
	private static final Map<String, Integer> FIELD_LENGTHS = Map.ofEntries(
		Map.entry("companyName", 100),
		Map.entry("shoppingmallName", 100),
		Map.entry("domain", 255),
		Map.entry("telephoneNumber", 255),
		Map.entry("officialEmail", 100),
		Map.entry("registrationNumber", 255),
		Map.entry("businessType", 100),
		Map.entry("address", 100),
		Map.entry("status", 25),
		Map.entry("mainItemsHandled", 255),
		Map.entry("withdrawalPossible", 25),
		Map.entry("initialScreenRequiredDisplay", 255),
		Map.entry("paymentMethods", 255),
		Map.entry("termsComplianceLevel", 255),
		Map.entry("privacyPolicy", 255),
		Map.entry("excessivePrivacyDataRequested", 255),
		Map.entry("buyerProtectionService", 25),
		Map.entry("secureServerInstalled", 100),
		Map.entry("certificationMark", 25),
		Map.entry("estimatedDeliveryDisplay", 25),
		Map.entry("returnShippingFee", 50),
		Map.entry("complaintBoard", 25),
		Map.entry("membershipCancelationMethod", 50),
		Map.entry("siteEstablishmentYear", 25)
	);

	// 문자열 공백 제거 후
	// 지정된 길이보다 짧으면 그대로 반환, 길면 substring(0, maxLength) 잘림
	public static String sanitize(String fieldName, String value) {
		String trimmed = value.trim();
		int maxLength = FIELD_LENGTHS.getOrDefault(fieldName, 255);
		return trimmed.length() > maxLength ? trimmed.substring(0, maxLength) : trimmed;
	}

	// 문자열 -> 정수타입 반환
	public static Integer parseInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			return 0;
		}
	}

	// 문자열 -> 날짜타입 반환
	public static LocalDate parseDate(String value) {
		try {
			return LocalDate.parse(value.trim());
		} catch (Exception e) {
			return LocalDate.now();
		}
	}
}
