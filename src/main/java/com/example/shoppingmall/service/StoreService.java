package com.example.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dto.StoreDto;
import com.example.shoppingmall.dto.StorePageableResponseDto;
import com.example.shoppingmall.dto.StoreSummaryResponseDto;
import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.repository.StoreRepository;

import jakarta.persistence.EntityNotFoundException;

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

	public List<StoreSummaryResponseDto> findTop10ByRatingAndStatus(int rating, String status) {
		List<StoreEntity> entities = storeRepository.findTop10ByRatingAndStatus(rating, status);

		List<StoreSummaryResponseDto> result = new ArrayList<>();

		for (int i = 0; i < entities.size(); i++) {
			StoreEntity entity = entities.get(i);
			StoreSummaryResponseDto dto = StoreSummaryResponseDto.from(entity);
			result.add(dto);
		}

		return result;
	}

	public StorePageableResponseDto findStoresPaging(int rating, String status, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<StoreEntity> entityPage = storeRepository.findByRatingAndStatus(rating, status, pageable);

		List<StoreSummaryResponseDto> dtoList = new ArrayList<>();
		List<StoreEntity> content = entityPage.getContent();

		for (int i = 0; i < content.size(); i++) {
			StoreEntity entity = content.get(i);
			StoreSummaryResponseDto dto = StoreSummaryResponseDto.from(entity);
			dtoList.add(dto);
		}

		return new StorePageableResponseDto(dtoList, entityPage.getNumber(), entityPage.getSize());
	}

	// status로 필터링된 업체 리스트 반환
	public List<StoreSummaryResponseDto> findStoresByStatus(String status) {
		List<StoreEntity> entities = storeRepository.findByStatusOrderByMonitoringDateDesc(status);

		List<StoreSummaryResponseDto> result = new ArrayList<>();
		for (StoreEntity entity : entities) {
			result.add(StoreSummaryResponseDto.from(entity));
		}

		return result;
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
