package oh29oh29;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class PersistableApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistableApplication.class, args);
    }

}
