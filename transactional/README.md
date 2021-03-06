# @Transactional

App01Runner : @Transactional 어노테이션 미적용
```text
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: insert into aaa (value, id) values (?, ?)
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: select aaa0_.id as id1_0_0_, aaa0_.value as value2_0_0_ from aaa aaa0_ where aaa0_.id=?
Hibernate: update aaa set value=? where id=?
```

App02Runner : updateBBB() 메서드에 @Transactional 어노테이션 적용
```text
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: insert into bbb (value, id) values (?, ?)
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: select bbb0_.id as id1_1_0_, bbb0_.value as value2_1_0_ from bbb bbb0_ where bbb0_.id=?
Hibernate: update bbb set value=? where id=?
```

App03Runner : updateBBB() 메서드를 호출하는 동일 클래스 내 run() 메서드에 @Transactional 어노테이션 적용
```text
Hibernate: select ccc0_.id as id1_2_0_, ccc0_.value as value2_2_0_ from ccc ccc0_ where ccc0_.id=?
Hibernate: insert into ccc (value, id) values (?, ?)
Hibernate: update ccc set value=? where id=?
```