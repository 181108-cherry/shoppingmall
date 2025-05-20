package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.StoreDto;
import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // Create
    public StoreDto createStore(StoreDto dto) {
        StoreEntity entity = dtoToEntity(dto);
        StoreEntity savedEntity = storeRepository.save(entity);
        return entityToDto(savedEntity);
    }

    // Update
    public StoreDto updateStore(Long id, StoreDto dto) {
        StoreEntity existing = storeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id " + id));

        updateEntityFromDto(existing, dto);
        StoreEntity savedEntity = storeRepository.save(existing);
        return entityToDto(savedEntity);
    }

    // Delete
    public void deleteStore(Long id) {
        if (!storeRepository.existsById(id)) {
            throw new EntityNotFoundException("Store not found with id " + id);
        }
        storeRepository.deleteById(id);
    }

    private static StoreEntity dtoToEntity(StoreDto dto) {
        StoreEntity entity = new StoreEntity();
        updateEntityFromDto(entity, dto);
        return entity;
    }

    private static void updateEntityFromDto(StoreEntity entity, StoreDto dto) {
        entity.setCompanyName(dto.getCompanyName());
        entity.setShoppingmallName(dto.getShoppingmallName());
        entity.setDomain(dto.getDomain());
        entity.setTelephoneNumber(dto.getTelephoneNumber());
        entity.setOfficialEmail(dto.getOfficialEmail());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setBusinessType(dto.getBusinessType());
        entity.setInitialRegistrationDate(dto.getInitialRegistrationDate());
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.getStatus());
        entity.setRating(dto.getRating());
        entity.setBusinessInfoRating(dto.getBusinessInfoRating());
        entity.setWithdrawalEvaluation(dto.getWithdrawalEvaluation());
        entity.setPaymentMethodEvaluation(dto.getPaymentMethodEvaluation());
        entity.setTermsEvaluation(dto.getTermsEvaluation());
        entity.setPrivacySecurityEvaluation(dto.getPrivacySecurityEvaluation());
        entity.setMainItemsHandled(dto.getMainItemsHandled());
        entity.setWithdrawalPossible(dto.getWithdrawalPossible());
        entity.setInitialScreenRequiredDisplay(dto.getInitialScreenRequiredDisplay());
        entity.setPaymentMethods(dto.getPaymentMethods());
        entity.setTermsComplianceLevel(dto.getTermsComplianceLevel());
        entity.setPrivacyPolicy(dto.getPrivacyPolicy());
        entity.setExcessivePrivacyDataRequested(dto.getExcessivePrivacyDataRequested());
        entity.setBuyerProtectionService(dto.getBuyerProtectionService());
        entity.setSecureServerInstalled(dto.getSecureServerInstalled());
        entity.setCertificationMark(dto.getCertificationMark());
        entity.setEstimatedDeliveryDisplay(dto.getEstimatedDeliveryDisplay());
        entity.setReturnShippingFee(dto.getReturnShippingFee());
        entity.setComplaintBoard(dto.getComplaintBoard());
        entity.setMembershipCancelationMethod(dto.getMembershipCancelationMethod());
        entity.setSiteEstablishmentYear(dto.getSiteEstablishmentYear());
        entity.setMonitoringDate(dto.getMonitoringDate());
    }

    private static StoreDto entityToDto(StoreEntity entity) {
        StoreDto dto = new StoreDto();
        dto.setCompanyName(entity.getCompanyName());
        dto.setShoppingmallName(entity.getShoppingmallName());
        dto.setDomain(entity.getDomain());
        dto.setTelephoneNumber(entity.getTelephoneNumber());
        dto.setOfficialEmail(entity.getOfficialEmail());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setBusinessType(entity.getBusinessType());
        dto.setInitialRegistrationDate(entity.getInitialRegistrationDate());
        dto.setAddress(entity.getAddress());
        dto.setStatus(entity.getStatus());
        dto.setRating(entity.getRating());
        dto.setBusinessInfoRating(entity.getBusinessInfoRating());
        dto.setWithdrawalEvaluation(entity.getWithdrawalEvaluation());
        dto.setPaymentMethodEvaluation(entity.getPaymentMethodEvaluation());
        dto.setTermsEvaluation(entity.getTermsEvaluation());
        dto.setPrivacySecurityEvaluation(entity.getPrivacySecurityEvaluation());
        dto.setMainItemsHandled(entity.getMainItemsHandled());
        dto.setWithdrawalPossible(entity.getWithdrawalPossible());
        dto.setInitialScreenRequiredDisplay(entity.getInitialScreenRequiredDisplay());
        dto.setPaymentMethods(entity.getPaymentMethods());
        dto.setTermsComplianceLevel(entity.getTermsComplianceLevel());
        dto.setPrivacyPolicy(entity.getPrivacyPolicy());
        dto.setExcessivePrivacyDataRequested(entity.getExcessivePrivacyDataRequested());
        dto.setBuyerProtectionService(entity.getBuyerProtectionService());
        dto.setSecureServerInstalled(entity.getSecureServerInstalled());
        dto.setCertificationMark(entity.getCertificationMark());
        dto.setEstimatedDeliveryDisplay(entity.getEstimatedDeliveryDisplay());
        dto.setReturnShippingFee(entity.getReturnShippingFee());
        dto.setComplaintBoard(entity.getComplaintBoard());
        dto.setMembershipCancelationMethod(entity.getMembershipCancelationMethod());
        dto.setSiteEstablishmentYear(entity.getSiteEstablishmentYear());
        dto.setMonitoringDate(entity.getMonitoringDate());
        return dto;
    }

}
