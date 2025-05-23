package com.example.shoppingmall.filter.csv;

import java.time.LocalDate;

import com.example.shoppingmall.entity.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
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
		return new StoreCsvDto(
			c[0], c[1], c[2], c[3], c[4], c[5], c[6],
			LocalDate.parse(c[7]), c[8], c[9],
			Integer.parseInt(c[10]), Integer.parseInt(c[11]), Integer.parseInt(c[12]),
			Integer.parseInt(c[13]), Integer.parseInt(c[14]), Integer.parseInt(c[15]),
			c[16], c[17], c[18], c[19], c[20], c[21],
			c[22], c[23], c[24], c[25], c[26], c[27],
			c[28], c[29], c[30], LocalDate.parse(c[31])
			);

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
