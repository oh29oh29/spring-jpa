package oh29oh29;

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
    public void run(ApplicationArguments args) throws Exception {
        final User user = saveUser();
        updateUser(user);
    }

    private User saveUser() {
        return userRepository.save(new User());
    }

    private void updateUser(User user) {
        final User findById = userRepository.findById(user.getId()).get();
        findById.setValue(10);
        userRepository.save(findById);
    }
}