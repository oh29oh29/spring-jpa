package oh29oh29.runner;

import oh29oh29.entity.User;
import oh29oh29.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final UserRepository userRepository;

    public AppRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        final User user = new User("oh29oh29");
        final User save = userRepository.save(user);
        System.out.println(save);
    }
}
