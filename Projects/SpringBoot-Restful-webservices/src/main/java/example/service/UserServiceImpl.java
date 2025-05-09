package example.service;

import example.Dto.UserDto;
import example.Mapper.AutoUserMapper;
import example.Mapper.UserMapper;
import example.entity.User;
import example.exception.EmailAlreadyExistsException;
import example.exception.ResourceNotFoundException;
import example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userdto) {

//        User user = userRepository.save(UserMapper.mapToUser(userdto));

        //using ModelMapper class to map instead of UserMapper
//        User user = userRepository.save(modelMapper.map(userdto,User.class));

        //using MapStruct for mapping
        Optional<User> userExists = userRepository.findByEmail(userdto.getEmail());
        System.out.println("printing line:"+userExists.get());
        if(userExists.isPresent()){
            throw new EmailAlreadyExistsException("Email Id Already Exixts");
        }
        User user = userRepository.save(AutoUserMapper.MAPPER.maptoUser(userdto));



        //return UserMapper.mapToUserDto(user);

        //using ModelMapper to return the userDto
//        return modelMapper.map(user, UserDto.class);

        //using Map Struct for mapping
        return AutoUserMapper.MAPPER.maptoUserDto(user);

    }

    @Override
    public UserDto getUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(
                ()->{
                   return new ResourceNotFoundException("User","id",id);
        }
        );

        //return UserMapper.mapToUserDto(user.get());

        //using ModelMapper map method
//        return modelMapper.map(user.get(), UserDto.class);

        //using mapstruct to return
        return AutoUserMapper.MAPPER.maptoUserDto(user);


    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> userList= userRepository.findAll();
//       List<UserDto> userDtoList = new ArrayList<>();
//        userList.stream().forEach(user->{
//            userDtoList.add(UserMapper.mapToUserDto(user));
//        });
//        List<UserDto> userDtoList = userList.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

        //using modelMapper instead of Manual one
//        List<UserDto> userDtoList = userList.stream().map(user->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        //Using Map Struct for DTO mapping
        List<UserDto> userDtoList = userList.stream().map(user->AutoUserMapper.MAPPER.maptoUserDto(user)).collect(Collectors.toList());


        return userDtoList;
    }

    @Override
    public void deleteUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(
                ()->{
                    return new ResourceNotFoundException("User","id",id);
                }
        );
         userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(User user) {
        User userupdated = userRepository.findById(user.getId()).orElseThrow(
                ()->{
                    return new ResourceNotFoundException("User","id",user.getId());
                }
        );
            userupdated.setFirstName( user.getFirstName() !=null ? user.getFirstName(): userupdated.getFirstName());
            userupdated.setLastName(user.getLastName() !=null ? user.getLastName() : userupdated.getLastName());
            userupdated.setEmail(user.getEmail() !=null ? user.getEmail(): userupdated.getEmail());

//        return UserMapper.mapToUserDto(userRepository.save(userupdated));

        //using ModalMapper classes instead of Mapperclass written
//        return modelMapper.map(userRepository.save(userupdated), UserDto.class);

        //using mapstruct for DTO mapping
        return AutoUserMapper.MAPPER.maptoUserDto(userRepository.save(userupdated));


    }
}
