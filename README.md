# 프로젝트 소개
본 프로젝트는 멀티모듈 구조로 설계된 서버 애플리케이션으로, 공공데이터 포털의 기상청 단기 예보 데이터를 DB에 저장하고 조회하는 기능을 제공합니다.

# 멀티모듈 구조
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
## 모듈 설명
### clients
- 기능: **외부 API와의** 통신 담당
- 특징:
  - ```RestTemplate```을 사용하여 외부 서비스와의 HTTP 통신을 수행합니다.
  - 모든 결과를 ```ClientResponse```라는 통일된 형식으로 상위 계층에 반환하여 일관성을 유지합니다.
  - 예외 처리 및 변경 가능성이 있는 부분을 모듈 내에서 해결하여 외부에 영향을 주지 않습니다.

### domain 
- 기능: **핵심 비즈니스 로직 처리**
- 특징:
  - ```MySQL```, ```Spring-Data-JPA```를 사용하여 데이터 관리 및 접근을 담당합니다.
  - 도메인 모델과 데이터 접근 로직(repository)을 포함하여, 애플리케이션의 비즈니스 규칙을 구현합니다.

### api
- 기능: **Restful API 형식으로 서비스 제공**
- 특징:
  - ```web``` 컴포넌트를 사용하여 HTTP 요청을 처리하고 응답합니다.
  - 이 모듈은 다양한 클라이언트 요청을 받아 적절한 서비스 로직을 호출하고, 그 결과를 사용자에게 전달하는 역할을 합니다.
* * *
## 주요 고민 사항
- 멀티 모듈이란? 특히 모듈은 무엇이고, 그 구분 기준이 뭘까?
- 외부 API의 변화 가능성에 어떻게 대처할 수 있을까?
- 외부 API의 변화와 실패를 어떻게 추적해야 할까?
- Client 모듈(외부 API 호출 담당)을 어떻게 설계 방법
- 서비스 영역은 어디에 위치해야 하는가?
- 기능 요구 사항이 명확하지 않을때, 어떤 방식으로 확장성을 고려할 수 있을까?
### Clients
```
example-multi-module
├─ client
│	├─ weather
│	│	├─ dto
│	│	│	├─ request
│	│	│	└─ response
│	│	└─ WeatherApiClient
│	├─ ...
│	└─ support
│	│	├─ ...
│	│	└─ ClientResponse
```
> 외부 API의 변화 가능성을 어떻게 대처할 것인가?

외부 API의 변화는 개발자가 제어할 수 없다. 이 부분에 대해 통일성 있게 다루고 대처하는 것이 중요하다고 판단했다. Client라는 모듈 내부에서 **외부 api 변화를 모두 책임지고 제어 및 추적하는 것을 목표**료 했다.

* *  *
# 학습 내용
- [[멀티모듈] 우아한 멀티모듈 정리(by. 권용근) #1. 멀티모듈이란?](https://velog.io/@bienlee/%EB%A9%80%ED%8B%B0%EB%AA%A8%EB%93%88-%EC%9A%B0%EC%95%84%ED%95%9C-%EB%A9%80%ED%8B%B0%EB%AA%A8%EB%93%88-%EC%A0%95%EB%A6%ACby.-%EA%B6%8C%EC%9A%A9%EA%B7%BC-1.-%EB%A9%80%ED%8B%B0%EB%AA%A8%EB%93%88%EC%9D%B4%EB%9E%80)

* * *
# TodoList
- 스웨거 작성
- 
