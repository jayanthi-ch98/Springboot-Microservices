package example.service;

import example.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public User getUser(Long id);

    public List<User> getAllUsers();

    public void deleteUser(Long id);

    public User updateUser(User user);
}
