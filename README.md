 # 각 모듈 설명
```
root
├─ example-multi-module
│	├─ api
│	│	├─ sync-application
│	│	└─ inquire-application
│	├─ client
│	│	├─ client
│	│	├─ config
│	│	└─ support
│	└─ domain
│	│	├─ domain
│	│	└─ repository
├─ build.gradle.kts
└─ settings.gradle.kts
```
## 각 모듈 설명
### clients: 외부 API 호출 관리
- 기능: 외부 API와의 통신을 담당합니다.
- 특징:
  - RestTemplate을 사용하여 외부 서비스와의 HTTP 통신을 수행합니다.
  - 모든 결과를 ClientResponse라는 통일된 형식으로 상위 계층에 반환하여 일관성을 유지합니다.
  - 예외 처리 및 변경 가능성이 있는 부분을 모듈 내에서 해결하여 외부에 영향을 주지 않습니다.

### domain 모듈: 주요 비즈니스 로직 처리
- 기능: 애플리케이션의 핵심 비즈니스 로직을 처리합니다.
- 특징:
  - MySQL, Spring-Data-JPA를 사용하여 데이터 관리 및 접근을 담당합니다.
  - 도메인 모델과 데이터 접근 로직(repository)을 포함하여, 애플리케이션의 비즈니스 규칙을 구현합니다.

### api: 사용자 요구사항을 Restful API로 제공
- 기능: 사용자의 요구사항을 수행하기 위해 다른 모듈들을 조합하여 Restful API 형식으로 제공합니다.
- 특징:
  - web 컴포넌트를 사용하여 HTTP 요청을 처리하고 응답합니다.
  - api 모듈은 시스템의 다른 모듈들과의 연결점 역할을 하며, 사용자 인터페이스와 비즈니스 로직 사이의 중개자 역할을 수행합니다.
  - 이 모듈은 다양한 클라이언트 요청을 받아 적절한 서비스 로직을 호출하고, 그 결과를 사용자에게 전달하는 역할을 합니다.
* * *
# 주요 고민사항
- API에서 가져오는 데이터를 DB에 어떻게 저장하면 좋을까?
   - 객체중심 VS DB 중심
- 구현대상 API의 스펙이 명확하지 않다.
	- 조회 시 어느정도의 데이터를 조회하는게 좋을까?
		DTO에 값을 설정할 수 있으므로 변경이 비교적 쉽다고 생각했다.
        단순히 DTO에 값을 담는것 정도로 제한.
- 멀티 모듈에서 모듈의 구분 기준은?        
- Scan 문제 해결!!!! 오마이센스
* *  *
# 학습 내용
- [[멀티모듈] 우아한 멀티모듈 정리(by. 권용근) #1. 멀티모듈이란?](https://velog.io/@bienlee/%EB%A9%80%ED%8B%B0%EB%AA%A8%EB%93%88-%EC%9A%B0%EC%95%84%ED%95%9C-%EB%A9%80%ED%8B%B0%EB%AA%A8%EB%93%88-%EC%A0%95%EB%A6%ACby.-%EA%B6%8C%EC%9A%A9%EA%B7%BC-1.-%EB%A9%80%ED%8B%B0%EB%AA%A8%EB%93%88%EC%9D%B4%EB%9E%80)

* * *
