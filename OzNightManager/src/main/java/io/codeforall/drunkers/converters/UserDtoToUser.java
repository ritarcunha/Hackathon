package io.codeforall.drunkers.converters;

import io.codeforall.drunkers.dtos.UserDto;
import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = (userDto.getId() !=null ? userService.get(userDto.getId()) : new User());

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setGroups(userDto.getGroups());

        return user;
    }
}
