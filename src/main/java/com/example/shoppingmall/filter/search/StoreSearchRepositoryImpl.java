package com.example.shoppingmall.filter.search;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.shoppingmall.entity.StoreEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreSearchRepositoryImpl implements StoreSearchRepositoryCustom {

	private final EntityManager entityManager;

	@Override
	public List<StoreEntity> searchWithCursor(String field, String keyword, Long lastId, int size) {
		String base = "SELECT s FROM StoreEntity s WHERE ";
		String fieldCondition = "";

		if("companyName".equals(field)) {
			fieldCondition = "s.companyName LIKE :keyword";
		} else if ("shoppingmallName".equals(field)) {
			fieldCondition = "s.shoppingmallName LIKE :keyword";
		} else if ("domain".equals(field)) {
			fieldCondition = "s.domain LIKE :keyword";
		}

		String cursorCondition = (lastId != null ) ? "AND s.id > :lastId" : "" ;
		String jpql = base + fieldCondition +cursorCondition + " ORDER BY s.id ASC";

		TypedQuery<StoreEntity> query = entityManager.createQuery(jpql, StoreEntity.class);
		query.setParameter("keyword", "%" + keyword + "%");

		if(lastId != null) {
			query.setParameter("lastId", lastId);
		}

		query.setMaxResults(size);
		return query.getResultList();

	}

}
