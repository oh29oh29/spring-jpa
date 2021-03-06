package oh29oh29;

import oh29oh29.entity.CCC;
import oh29oh29.repository.CCCRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Component
public class App03Runner implements ApplicationRunner {

    private final CCCRepository cccRepository;

    public App03Runner(
            CCCRepository cccRepository
    ) {
        this.cccRepository = cccRepository;
    }

    /**
     * 일반적인 엔티티와 Persistable 을 구현하여 isNew 를 추가한 엔티티에 대하여
     * insert 와 update 의 의도를 갖고 구현했을 때
     * 실제 쿼리는 어떻게 실행되는지 살펴보자.
     * */
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n===== Starting App03Runner =====");

        /**
         * 일반적인 엔티티에 대하여 insert 와 update
         * */
        insertCCC();
        updateCCC();
    }

    public void insertCCC() {
        cccRepository.save(new CCC("ccc"));
    }

    public void updateCCC() {
        final Optional<CCC> optional = cccRepository.findById("ccc");
        if (optional.isEmpty()) return;

        final CCC ccc = optional.get();
        ccc.setValue(1);
        cccRepository.save(ccc);
    }
}
