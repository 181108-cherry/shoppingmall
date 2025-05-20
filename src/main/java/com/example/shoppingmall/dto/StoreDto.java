package com.example.shoppingmall.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StoreDto {

    @NotBlank
    @Size(max = 25)
    private String companyName;

    @NotBlank
    @Size(max = 100)
    private String shoppingmallName;

    @NotBlank
    @Size(max = 255)
    private String domain;

    @Size(max = 255)
    private String telephoneNumber;

    @Email
    @Size(max = 100)
    private String officialEmail;

    @NotBlank
    private String registrationNumber;

    @Size(max = 25)
    private String businessType;

    @NotNull
    private LocalDate initialRegistrationDate;

    @Size(max = 100)
    private String address;

    @NotBlank
    @Size(max = 25)
    private String status;

    @NotNull
    private Integer rating;

    @NotNull
    private Integer businessInfoRating;

    @NotNull
    private Integer withdrawalEvaluation;

    @NotNull
    private Integer paymentMethodEvaluation;

    @NotNull
    private Integer termsEvaluation;

    @NotNull
    private Integer privacySecurityEvaluation;

    @Size(max = 100)
    private String mainItemsHandled;

    @NotBlank
    @Size(max = 25)
    private String withdrawalPossible;

    @Size(max = 100)
    private String initialScreenRequiredDisplay;

    @Size(max = 100)
    private String paymentMethods;

    @NotBlank
    @Size(max = 100)
    private String termsComplianceLevel;

    @NotBlank
    @Size(max = 100)
    private String privacyPolicy;

    @Size(max = 100)
    private String excessivePrivacyDataRequested;

    @NotBlank
    @Size(max = 25)
    private String buyerProtectionService;

    @Size(max = 100)
    private String secureServerInstalled;

    @Size(max = 25)
    private String certificationMark;

    @NotBlank
    @Size(max = 25)
    private String estimatedDeliveryDisplay;

    @NotBlank
    @Size(max = 50)
    private String returnShippingFee;

    @NotBlank
    @Size(max = 25)
    private String complaintBoard;

    @NotBlank
    @Size(max = 50)
    private String membershipCancelationMethod;

    @Size(max = 25)
    private String siteEstablishmentYear;

    @NotNull
    private LocalDate monitoringDate;
}
