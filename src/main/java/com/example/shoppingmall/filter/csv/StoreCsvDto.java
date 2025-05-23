package com.example.shoppingmall.filter.csv;

import java.time.LocalDate;

import com.example.shoppingmall.entity.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreCsvDto {
	private String companyName;
	private String shoppingmallName;
	private String domain;
	private String telephoneNumber;
	private String officialEmail;
	private String registrationNumber;
	private String businessType;
	private LocalDate initialRegistrationDate;
	private String address;
	private String status;
	private Integer rating;
	private Integer businessInfoRating;
	private Integer withdrawalEvaluation;
	private Integer paymentMethodEvaluation;
	private Integer termsEvaluation;
	private Integer privacySecurityEvaluation;
	private String mainItemsHandled;
	private String withdrawalPossible;
	private String initialScreenRequiredDisplay;
	private String paymentMethods;
	private String termsComplianceLevel;
	private String privacyPolicy;
	private String excessivePrivacyDataRequested;
	private String buyerProtectionService;
	private String secureServerInstalled;
	private String certificationMark;
	private String estimatedDeliveryDisplay;
	private String returnShippingFee;
	private String complaintBoard;
	private String membershipCancelationMethod;
	private String siteEstablishmentYear;
	private LocalDate monitoringDate;

	public static StoreCsvDto fromCsv(String[] c) {
		StoreCsvDto dto = new StoreCsvDto();
		dto.companyName = CsvDataSubStr.sanitize("companyName", c[0]);
		dto.shoppingmallName = CsvDataSubStr.sanitize("shoppingmallName", c[1]);
		dto.domain = CsvDataSubStr.sanitize("domain", c[2]);
		dto.telephoneNumber = CsvDataSubStr.sanitize("telephoneNumber", c[3]);
		dto.officialEmail = CsvDataSubStr.sanitize("officialEmail", c[4]);
		dto.registrationNumber = CsvDataSubStr.sanitize("registrationNumber", c[5]);
		dto.businessType = CsvDataSubStr.sanitize("businessType", c[6]);
		dto.initialRegistrationDate = CsvDataSubStr.parseDate(c[7]);
		dto.address = CsvDataSubStr.sanitize("address", c[8]);
		dto.status = CsvDataSubStr.sanitize("status", c[9]);
		dto.rating = CsvDataSubStr.parseInt(c[10]);
		dto.businessInfoRating = CsvDataSubStr.parseInt(c[11]);
		dto.withdrawalEvaluation = CsvDataSubStr.parseInt(c[12]);
		dto.paymentMethodEvaluation = CsvDataSubStr.parseInt(c[13]);
		dto.termsEvaluation = CsvDataSubStr.parseInt(c[14]);
		dto.privacySecurityEvaluation = CsvDataSubStr.parseInt(c[15]);
		dto.mainItemsHandled = CsvDataSubStr.sanitize("mainItemsHandled", c[16]);
		dto.withdrawalPossible = CsvDataSubStr.sanitize("withdrawalPossible", c[17]);
		dto.initialScreenRequiredDisplay = CsvDataSubStr.sanitize("initialScreenRequiredDisplay", c[18]);
		dto.paymentMethods = CsvDataSubStr.sanitize("paymentMethods", c[19]);
		dto.termsComplianceLevel = CsvDataSubStr.sanitize("termsComplianceLevel", c[20]);
		dto.privacyPolicy = CsvDataSubStr.sanitize("privacyPolicy", c[21]);
		dto.excessivePrivacyDataRequested = CsvDataSubStr.sanitize("excessivePrivacyDataRequested", c[22]);
		dto.buyerProtectionService = CsvDataSubStr.sanitize("buyerProtectionService", c[23]);
		dto.secureServerInstalled = CsvDataSubStr.sanitize("secureServerInstalled", c[24]);
		dto.certificationMark = CsvDataSubStr.sanitize("certificationMark", c[25]);
		dto.estimatedDeliveryDisplay = CsvDataSubStr.sanitize("estimatedDeliveryDisplay", c[26]);
		dto.returnShippingFee = CsvDataSubStr.sanitize("returnShippingFee", c[27]);
		dto.complaintBoard = CsvDataSubStr.sanitize("complaintBoard", c[28]);
		dto.membershipCancelationMethod = CsvDataSubStr.sanitize("membershipCancelationMethod", c[29]);
		dto.siteEstablishmentYear = CsvDataSubStr.sanitize("siteEstablishmentYear", c[30]);
		dto.monitoringDate = CsvDataSubStr.parseDate(c[31]);
		return dto;
	}


	public StoreEntity toEntity() {
		return StoreEntity.builder()
			.companyName(companyName)
			.shoppingmallName(shoppingmallName)
			.domain(domain)
			.telephoneNumber(telephoneNumber)
			.officialEmail(officialEmail)
			.registrationNumber(registrationNumber)
			.businessType(businessType)
			.initialRegistrationDate(initialRegistrationDate)
			.address(address)
			.status(status)
			.rating(rating)
			.businessInfoRating(businessInfoRating)
			.withdrawalEvaluation(withdrawalEvaluation)
			.paymentMethodEvaluation(paymentMethodEvaluation)
			.termsEvaluation(termsEvaluation)
			.privacySecurityEvaluation(privacySecurityEvaluation)
			.mainItemsHandled(mainItemsHandled)
			.withdrawalPossible(withdrawalPossible)
			.initialScreenRequiredDisplay(initialScreenRequiredDisplay)
			.paymentMethods(paymentMethods)
			.termsComplianceLevel(termsComplianceLevel)
			.privacyPolicy(privacyPolicy)
			.excessivePrivacyDataRequested(excessivePrivacyDataRequested)
			.buyerProtectionService(buyerProtectionService)
			.secureServerInstalled(secureServerInstalled)
			.certificationMark(certificationMark)
			.estimatedDeliveryDisplay(estimatedDeliveryDisplay)
			.returnShippingFee(returnShippingFee)
			.complaintBoard(complaintBoard)
			.membershipCancelationMethod(membershipCancelationMethod)
			.siteEstablishmentYear(siteEstablishmentYear)
			.monitoringDate(monitoringDate)
			.build();
	}
}
