# kakaopaysec
## 개발환경
- Spring Boot 2.2.5
- JDK 8
- maven 디폴트 빌드

## 문제해결
1, 2번
  - 필요한 데이터를 쿼리로 추출하여 응답
  
3번 
  - 데이터를 추출 후 json 리턴 타입을 맞추기 위해 데이터 가공 후 리턴
  
4번 
  - Post방식으로 데이터 수신 후 데이터를 추출하고 없는 데이터나 분당점이 들어올 시 exception 을 발생
  - 판교점이 들어올 시 분당점의 거래금액을 합해서 리턴 

   ex) input 예시
     
     {
        "branchName":"판교점"
     }
  
## 실행방법
1. http://localhost:8888/customer-amt      : 2018, 2019년 각 연도별 거래금액이 가장 많은 고객
2. http://localhost:8888/customer-nottrade : 2018 또는 2019 에 거래가 없는 고객
3. http://localhost:8888/branch-rank       : 연도별 관리점별 거래금액 합계
4. http://localhost:8888/branchbyname      : 지점명 입력시 해당 지점의 거래금액 합계
