# 🛒 서울시 쇼핑몰 프로젝트

서울시 인터넷 쇼핑물 현황 CRUD 프로젝트

---

## 👩‍💻 개발자
강다연 : 팀장, 전체평가 필터 조회, PPT 작성

배재훈 : 업소상태 필터 조회, 모니터링날짜 내림차순, README 작성

김민준 :  top 10 , pageable 기반 업체 리스트 조회, 발표대본 작성 

한시습 : 쇼핑몰 CUD, 시연 영상 촬영

손혜빈 : 업체 조회(필터), 업체 상세 조회, 검색기능, 프로젝트 발표

## 📁 폴더 구조
```
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┗ 📂shoppingmall
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreFilterResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StorePageableResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreSummaryResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂filter
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂commond
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommonResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ResponseCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂csv
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CsvController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CsvDataSubStr.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CsvLoader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CsvService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreCsvDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂query
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreQueryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreQueryDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreQueryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂search
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreSearchCondition.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreSearchController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreSearchCursorRequest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreSearchRepositoryCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreSearchRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StoreSearchResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreSearchService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ShoppingmallApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📜application.properties
 ┃ ┃ ┗ 📜shoppingmall.csv
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┗ 📂shoppingmall
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ShoppingmallApplicationTests.java

```


## 🛠️ 기술 스택

- **IDE**: IntelliJ IDEA
- **언어**: Java 17
- **Backend**: Spring Boot, Spring Web, Spring Data JPA, Lombok 
- **DB**: MySQL
- **빌드 도구**: Gradle
- **기타 도구**: Postman

---
