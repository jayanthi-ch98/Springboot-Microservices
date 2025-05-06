package example.service;

import example.entity.User;
import example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user=userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
       List<User> userList= userRepository.findAll();
        return userList;
    }

    @Override
    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        User userupdated = userRepository.findById(user.getId()).get();
        userupdated.setFirstName(user.getFirstName());
        userupdated.setLastName(user.getLastName());
        userupdated.setEmail(user.getEmail());
        return userRepository.save(userupdated);
    }
}
