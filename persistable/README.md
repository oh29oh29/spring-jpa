# Persistable

https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.entity-persistence.saving-entites.strategies

App01Runner : 일반적인 엔티티의 insert 와 update

```text
// insertAAA();
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: insert into aaa (value, id) values (?, ?)

// updateAAA();
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: update aaa set value=? where id=?
```

App02Runner : Persistable 을 구현하여 isNew 기능을 활용한 엔티티의 insert 와 update

```text
// insertBBB();
Hibernate: insert into bbb (value, id) values (?, ?)

// updateBBB();
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: update bbb set value=? where id=?
```