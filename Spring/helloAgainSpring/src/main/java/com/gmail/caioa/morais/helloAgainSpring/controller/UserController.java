package com.gmail.caioa.morais.helloAgainSpring.controller;

import com.gmail.caioa.morais.helloAgainSpring.dto.AuthDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUserDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TokenDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UserDTO;
import com.gmail.caioa.morais.helloAgainSpring.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private UserService userService;


    public TokenDTO login (@RequestBody AuthDTO authDTO) {
        return userService.login(authDTO);
    }

    public UserDTO create (@RequestBody CreateUserDTO createUserDTO){
        return userService.create(createUserDTO);
    }
}
