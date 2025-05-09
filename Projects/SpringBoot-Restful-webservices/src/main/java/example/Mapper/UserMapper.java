package example.Mapper;

import example.Dto.UserDto;
import example.entity.User;

//Mapper Classes for the UserDto and User classes
public class UserMapper {

    public static User mapToUser(UserDto userDto){
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return user;
    }

    public static UserDto mapToUserDto(User user){
        UserDto userdto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userdto;
    }
}
