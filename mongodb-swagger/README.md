
# spring boot + mongodb
Spring Boot + MongoDB 예제

# RestController
기본 CRUD Mapping 적용

# Swagger 적용
- 개발자가 REST 웹 서비스를 설계, 빌드, 문서화, 소비하는 일을 도와주는 대형 도구 생태계의 지원을 받는 오픈 소스 소프트웨어 프레임워크이다. 대부분의 사용자들은 스웨거 UI 도구를 통해 스웨거를 식별하며 스웨거 툴셋에는 자동화된 문서화, 코드 생성, 테스트 케이스 생성 지원이 포함된다.
- @EnableSwagger2
    - @Configuration 과 같이 명시하여 Swagger 환경 설정
- @Api
    - 해당 class가 Swagger에 노출될 정보라는 것을 명시하여 사용
- @ApiOperation
    - 해당 API의 명칭과 설명를 작성할때 사용
- @ApiResponse
    - 해당 API의 응답코드별 메시지를 작성할때 사용
- @ApiParam
    - 변수, 필수 여부, 테스트 예제 등을 작성할때 사용
- 참고 : https://swagger.io/

# application.properties
spring.data.mongodb.uri=mongodb://{host}:{port}/{databasename}
