package io.codeforall.drunkers.rest;

import io.codeforall.drunkers.converters.UserDtoToUser;
import io.codeforall.drunkers.converters.UserToUserDto;
import io.codeforall.drunkers.dtos.UserDto;
import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.services.LoginService;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.LoginContext;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/login")
public class RestLoginController {
    private LoginService loginService;
    private UserToUserDto userConverter = new UserToUserDto();
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
    @RequestMapping(method = RequestMethod.GET, path = {"/{username}/{password}"})
    public ResponseEntity<UserDto> login(@RequestBody String username,@RequestBody String password) {
      User user = loginService.getUserByUsernameAndPassword(username,password);
        if (user.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userConverter.convert(user), HttpStatus.OK);


    }

}
