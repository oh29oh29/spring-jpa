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

    public App03Runner(CCCRepository cccRepository) {
        this.cccRepository = cccRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n===== Starting App03Runner =====");

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
