package oh29oh29;

import oh29oh29.entity.BBB;
import oh29oh29.repository.BBBRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Component
public class App02Runner implements ApplicationRunner {

    private final BBBRepository bbbRepository;

    public App02Runner(
            BBBRepository bbbRepository
    ) {
        this.bbbRepository = bbbRepository;
    }

    /**
     * 일반적인 엔티티와 Persistable 을 구현하여 isNew 를 추가한 엔티티에 대하여
     * insert 와 update 의 의도를 갖고 구현했을 때
     * 실제 쿼리는 어떻게 실행되는지 살펴보자.
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n===== Starting App02Runner =====");

        /**
         * 일반적인 엔티티에 대하여 insert 와 update
         * */
        insertBBB();
        updateBBB();
    }

    public void insertBBB() {
        bbbRepository.save(new BBB("bbb"));
    }

    @Transactional
    public void updateBBB() {
        final Optional<BBB> optional = bbbRepository.findById("bbb");
        if (optional.isEmpty()) return;

        final BBB bbb = optional.get();
        bbb.setValue(1);
        bbbRepository.save(bbb);
    }
}
