package example.service;

import example.Dto.UserDto;
import example.entity.User;

import java.util.List;

public interface UserService {

//    public User createUser(User user);
    //changing the class to user UserDTO object instead of User class
    public UserDto createUser(UserDto userDto);

    public UserDto getUser(Long id);

    public List<UserDto> getAllUsers();

    public void deleteUser(Long id);

    public UserDto updateUser(User user);
}
