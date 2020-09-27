
## Default setting  
  
#### application.yml  
  
- spring.jpa.properties.hibernate.dialect  
  - 표준 SQL(ANSI SQL)을 지키지 않는 특정 벤더별 기능을 방언(dialect)라고 부른다.  
  - JPA 는 특정 database 에 종속되지 않으며, 직접 SQL 을 작성하고 실행하는 형태이기 때문에 별도 dialect 설정을 해주면 JPA 가 DBMS 에 맞는 쿼리를 생성한다.  
      
- spring.jpa.generate-ddl  
  - entity 설정을 참고하여 application 실행 시정메 hibernate 에서 자동으로 DDL 을 생성하여 table 설정을 자동으로 수행할지 지정하는 옵션.  
  - 설정 가능한 값은 true or false.  
  
- spring.jpa.hibernate.ddl-auto  
  - JPA 의 database 초기화 전략.  
  - generate-ddl 설정보다 좀 더 상세한 설정.  
  - 설정 가능한 값은 none, create-drop, create, update, validate  
    > none : 아무것도 실행하지 않음 (대부분의 database 에서 기본값)  
    create-drop : SessionFactory 가 시작될 때 drop 및 생성된 DDL 을 실행하고, SessionFactory가 종료될 때 drop 을 실행 (in-memory database 의 경우 기본값)  
    create : SessionFactory 가 시작될 때 drop 을 실행하고 생성된 DDL 을 실행  
    update : 변경된 schema 를 적용  
    validate : 변경된 schema 있다면 변경점을 출력하고 application 을 종료  

- spring.jpa.open-in-view
    - [참고](https://kingbbode.tistory.com/27)

- spring.jpa.hibernate.show_sql
    - hibernate 가 database 에 날리는 모든 query(DDL, DML) 을 logging.
    - 설정 가능한 값은 true or false

- spring.jpa.hibernate.format_sql
    - show_sql 을 true 설정 시, query 를 formatting 해서 보기 좋게 logging.
    - 설정 가능한 값은 true or false
    
- logging.level.org.hibernate.type.descriptor.sql
    - trace 로 값을 설정하면 query log 중 ? 에 들어가는 값을 logging.
    - logging.level.org.hibernate.type 을 trace 로 설정해도 동일하게 logging 됨. (둘의 차이점은 앞으로 더 알게되면 작성할 예정)
 
  
