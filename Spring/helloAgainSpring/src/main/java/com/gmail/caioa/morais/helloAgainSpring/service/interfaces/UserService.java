package com.gmail.caioa.morais.helloAgainSpring.service.interfaces;

import com.gmail.caioa.morais.helloAgainSpring.dto.AuthDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUserDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TokenDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {

    TokenDTO login(AuthDTO authDTO);
    UserDTO create(CreateUserDTO createUserDTO);

}
