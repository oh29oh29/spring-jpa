package oh29oh29;

import oh29oh29.entity.AAA;
import oh29oh29.repository.AAARepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class App01Runner implements ApplicationRunner {

    private final AAARepository aaaRepository;

    public App01Runner(
            AAARepository aaaRepository
    ) {
        this.aaaRepository = aaaRepository;
    }

    /**
     * 일반적인 엔티티와 Persistable 을 구현하여 isNew 를 추가한 엔티티에 대하여
     * insert 와 update 의 의도를 갖고 구현했을 때
     * 실제 쿼리는 어떻게 실행되는지 살펴보자.
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n===== Starting App01Runner =====");

        /**
         * 일반적인 엔티티에 대하여 insert 와 update
         * */
        insertAAA();
        updateAAA();
    }

    public void insertAAA() {
        aaaRepository.save(new AAA("aaa"));
    }

    public void updateAAA() {
        final Optional<AAA> optional = aaaRepository.findById("aaa");
        if (optional.isEmpty()) return;

        final AAA aaa = optional.get();
        aaa.setValue(1);
        aaaRepository.save(aaa);
    }
}
