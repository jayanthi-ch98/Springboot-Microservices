package example.Mapper;

import example.Dto.UserDto;
import example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto maptoUserDto(User user);

    User maptoUser(UserDto user);
}


