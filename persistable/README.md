# Persistable

https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.entity-persistence.saving-entites.strategies

AppRunner.java 중 아래와 같은 메서드가 있다.

```java
@Transactional
public void updateUser(User user){
    final User findById = userRepository.findById(user.getId()).get();
    findById.setValue(10);
    userRepository.save(findById);
}
```

@Transactional을 걸면 실제 기대되는 쿼리는 아래와 같다.

```sql
select user0_.id as id1_0_0_, user0_.value as value2_0_0_ from user user0_ where user0_.id=?
update user set value=? where id=?
```

하지만 실행하여 로그를 보면 아래와 같다.

```sql
select user0_.id as id1_0_0_, user0_.value as value2_0_0_ from user user0_ where user0_.id=?
select user0_.id as id1_0_0_, user0_.value as value2_0_0_ from user user0_ where user0_.id=?
update user set value=? where id=?
```

왜 그럴까?