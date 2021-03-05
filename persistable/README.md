# Persistable

https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.entity-persistence.saving-entites.strategies

일반적인 엔티티의 insert 와 update

```text
// insertAAA();
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: insert into aaa (value, id) values (?, ?)

// updateAAA();
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: update aaa set value=? where id=?
```

Persistable 을 구현하여 isNew 기능을 활용한 엔티티의 insert 와 update

```text
// insertBBB();
Hibernate: insert into bbb (value, id) values (?, ?)

// updateBBB();
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: update bbb set value=? where id=?
```

테스트를 하던 중 이해가 안가는 부분을 발견하였는데,  
update 를 의도하는 메서드에 @Transactional 을 걸었을 경우 실행하는 쿼리가 예상했던것과는 다르게 실행되었다.

@Transactional 을 걸면 기대되는 쿼리는 아래와 같았는데 

```sql
select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
update bbb set value=? where id=?
```

실제 실행하여 로그를 보면 아래와 같았다.

```sql
// bbbRepository.findById("bbb");
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?

// bbbRepository.save(bbb);
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: update bbb set value=? where id=?
```

왜 그럴까?