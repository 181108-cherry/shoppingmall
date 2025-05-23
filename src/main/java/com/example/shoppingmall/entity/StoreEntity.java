package com.example.shoppingmall.entity;

import java.time.LocalDate;

import com.example.shoppingmall.dto.StoreDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "store")
@Getter
@Setter
public class StoreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // PK

	@Column(name = "company_name", length = 25, nullable = false) // sql null 금지
	private String companyName;                      // 상호

	@Column(name = "shoppingmall_name", length = 100, nullable = false)
	private String shoppingmallName;                 // 쇼핑몰명

	@Column(length = 255, nullable = false)
	private String domain;                           // 도메인명

	@Column(name = "telephone_number")
	private String telephoneNumber;                 // 전화번호

	@Column(name = "official_email", length = 100)
	private String officialEmail;                    // 운영자이메일

	@Column(name = "registration_number", nullable = false)
	private String registrationNumber;              // 통신판매번호

	@Column(name = "business_type", length = 25)
	private String businessType;                     // 영업형태

	@Column(name = "initial_registration_date", nullable = false)
	private LocalDate initialRegistrationDate;       // 최초신고일자

	@Column(length = 100)
	private String address;                          // 회사주소

	@Column(length = 25, nullable = false)
	private String status;                           // 업소상태

	@Column(nullable = false)
	private Integer rating;                          // 전체평가

	@Column(name = "business_info_rating", nullable = false)
	private Integer businessInfoRating;              // 사업자정보표시평가

	@Column(name = "withdrawal_evaluation", nullable = false)
	private Integer withdrawalEvaluation;            // 청약철회평가

	@Column(name = "payment_method_evaluation", nullable = false)
	private Integer paymentMethodEvaluation;        // 결제방법평가

	@Column(name = "terms_evaluation", nullable = false)
	private Integer termsEvaluation;                 // 이용약관평가

	@Column(name = "privacy_security_evaluation", nullable = false)
	private Integer privacySecurityEvaluation;       // 개인정보보안평가

	@Column(name = "main_items_handled", length = 100)
	private String mainItemsHandled;                 // 주요취급품목

	@Column(name = "withdrawal_possible", length = 25, nullable = false)
	private String withdrawalPossible;               // 청약철회가능여부

	@Column(name = "initial_screen_required_display", length = 100)
	private String initialScreenRequiredDisplay;     // 초기화면필수항목중표시사항

	@Column(name = "payment_methods", length = 100)
	private String paymentMethods;                   // 결제방법

	@Column(name = "terms_compliance_level", length = 100, nullable = false)
	private String termsComplianceLevel;             // 이용약관준수정도

	@Column(name = "privacy_policy", length = 100, nullable = false)
	private String privacyPolicy;                    // 개인정보취급방침

	@Column(name = "excessive_privacy_data_requested", length = 100)
	private String excessivePrivacyDataRequested;    // 표준약관이상개인정보항목요구

	@Column(name = "buyer_protection_service", length = 25, nullable = false)
	private String buyerProtectionService;           // 구매안전서비스

	@Column(name = "secure_server_installed", length = 100)
	private String secureServerInstalled;            // 보안서버설치

	@Column(name = "certification_mark", length = 25)
	private String certificationMark;                // 인증마크

	@Column(name = "estimated_delivery_display", length = 25, nullable = false)
	private String estimatedDeliveryDisplay;         // 배송예정일표시

	@Column(name = "return_shipping_fee", length = 50, nullable = false)
	private String returnShippingFee;                // 철회시배송비부담여부

	@Column(name = "complaint_board", length = 25, nullable = false)
	private String complaintBoard;                   // 고객불만게시판운영

	@Column(name = "membership_cancelation_method", length = 50, nullable = false)
	private String membershipCancelationMethod;      // 회원탈퇴방법

	@Column(name = "site_establishment_year", length = 25)
	private String siteEstablishmentYear;            // 사이트개설년도

	@Column(name = "monitoring_date", nullable = false)
	private LocalDate monitoringDate;                // 모니터링날짜

	// 모든 필드를 DTO로부터 업데이트
	public void updateEntityFromDto(StoreDto dto) {
		this.companyName = dto.getCompanyName();
		this.shoppingmallName = dto.getShoppingmallName();
		this.domain = dto.getDomain();
		this.telephoneNumber = dto.getTelephoneNumber();
		this.officialEmail = dto.getOfficialEmail();
		this.registrationNumber = dto.getRegistrationNumber();
		this.businessType = dto.getBusinessType();
		this.initialRegistrationDate = dto.getInitialRegistrationDate();
		this.address = dto.getAddress();
		this.status = dto.getStatus();
		this.rating = dto.getRating();
		this.businessInfoRating = dto.getBusinessInfoRating();
		this.withdrawalEvaluation = dto.getWithdrawalEvaluation();
		this.paymentMethodEvaluation = dto.getPaymentMethodEvaluation();
		this.termsEvaluation = dto.getTermsEvaluation();
		this.privacySecurityEvaluation = dto.getPrivacySecurityEvaluation();
		this.mainItemsHandled = dto.getMainItemsHandled();
		this.withdrawalPossible = dto.getWithdrawalPossible();
		this.initialScreenRequiredDisplay = dto.getInitialScreenRequiredDisplay();
		this.paymentMethods = dto.getPaymentMethods();
		this.termsComplianceLevel = dto.getTermsComplianceLevel();
		this.privacyPolicy = dto.getPrivacyPolicy();
		this.excessivePrivacyDataRequested = dto.getExcessivePrivacyDataRequested();
		this.buyerProtectionService = dto.getBuyerProtectionService();
		this.secureServerInstalled = dto.getSecureServerInstalled();
		this.certificationMark = dto.getCertificationMark();
		this.estimatedDeliveryDisplay = dto.getEstimatedDeliveryDisplay();
		this.returnShippingFee = dto.getReturnShippingFee();
		this.complaintBoard = dto.getComplaintBoard();
		this.membershipCancelationMethod = dto.getMembershipCancelationMethod();
		this.siteEstablishmentYear = dto.getSiteEstablishmentYear();
		this.monitoringDate = dto.getMonitoringDate();
	}

	// 엔터티를 DTO로 변환
	public StoreDto updateDtofromEntity() {
		StoreDto dto = new StoreDto();
		dto.setCompanyName(this.getCompanyName());
		dto.setShoppingmallName(this.getShoppingmallName());
		dto.setDomain(this.getDomain());
		dto.setTelephoneNumber(this.getTelephoneNumber());
		dto.setOfficialEmail(this.getOfficialEmail());
		dto.setRegistrationNumber(this.getRegistrationNumber());
		dto.setBusinessType(this.getBusinessType());
		dto.setInitialRegistrationDate(this.getInitialRegistrationDate());
		dto.setAddress(this.getAddress());
		dto.setStatus(this.getStatus());
		dto.setRating(this.getRating());
		dto.setBusinessInfoRating(this.getBusinessInfoRating());
		dto.setWithdrawalEvaluation(this.getWithdrawalEvaluation());
		dto.setPaymentMethodEvaluation(this.getPaymentMethodEvaluation());
		dto.setTermsEvaluation(this.getTermsEvaluation());
		dto.setPrivacySecurityEvaluation(this.getPrivacySecurityEvaluation());
		dto.setMainItemsHandled(this.getMainItemsHandled());
		dto.setWithdrawalPossible(this.getWithdrawalPossible());
		dto.setInitialScreenRequiredDisplay(this.getInitialScreenRequiredDisplay());
		dto.setPaymentMethods(this.getPaymentMethods());
		dto.setTermsComplianceLevel(this.getTermsComplianceLevel());
		dto.setPrivacyPolicy(this.getPrivacyPolicy());
		dto.setExcessivePrivacyDataRequested(this.getExcessivePrivacyDataRequested());
		dto.setBuyerProtectionService(this.getBuyerProtectionService());
		dto.setSecureServerInstalled(this.getSecureServerInstalled());
		dto.setCertificationMark(this.getCertificationMark());
		dto.setEstimatedDeliveryDisplay(this.getEstimatedDeliveryDisplay());
		dto.setReturnShippingFee(this.getReturnShippingFee());
		dto.setComplaintBoard(this.getComplaintBoard());
		dto.setMembershipCancelationMethod(this.getMembershipCancelationMethod());
		dto.setSiteEstablishmentYear(this.getSiteEstablishmentYear());
		dto.setMonitoringDate(this.getMonitoringDate());
		return dto;
	}
}
