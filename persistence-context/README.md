## Persistence context  
  
#### JpaFirstRunner.java
  
- @PersistenceContext
    - EntityManager 주입을 선언하는 JPA 의 annotation.
    - 타입을 지정할 수 있으며, 기본값으로는 TRANSACTION, 그 외에는 EXTENDED 이 있음.
    > persistence context : entity 를 영구 저장하는 환경

- EntityManager
    - 특정 작업을 위해 database 에  access 하는 역할.
    - entity 를 database 에 insert, update, remove, find 할 수 있음.

- @Transactional

#### JpaSecondRunner.java

- Session