package io.codeforall.drunkers.converters;

import io.codeforall.drunkers.dtos.UserDto;
import io.codeforall.drunkers.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto userDto= new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());


        return userDto;
    }
}
