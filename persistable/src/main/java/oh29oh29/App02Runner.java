package oh29oh29;

import oh29oh29.entity.BBB;
import oh29oh29.repository.BBBRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class App02Runner implements ApplicationRunner {

    private final BBBRepository bbbRepository;

    public App02Runner(BBBRepository bbbRepository) {
        this.bbbRepository = bbbRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n===== Starting App02Runner =====");

        /**
         * Persistable 을 구현한 엔티티에 대하여 insert 와 update
         * */
        insertBBB();
        updateBBB();
    }

    public void insertBBB() {
        bbbRepository.save(new BBB("bbb"));
    }

    public void updateBBB() {
        final Optional<BBB> optional = bbbRepository.findById("bbb");
        if (optional.isEmpty()) return;

        final BBB bbb = optional.get();
        bbb.setValue(1);
        bbbRepository.save(bbb);
    }


}
