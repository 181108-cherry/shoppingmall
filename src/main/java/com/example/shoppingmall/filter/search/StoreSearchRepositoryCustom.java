package com.example.shoppingmall.filter.search;

import java.util.List;

import com.example.shoppingmall.entity.StoreEntity;

public interface StoreSearchRepositoryCustom {
	List<StoreEntity> searchWithCursor(String field, String keyword, Long lastId, int size);
}
