package com.gmail.caioa.morais.helloAgainSpring.service;

import com.gmail.caioa.morais.helloAgainSpring.dto.*;
import com.gmail.caioa.morais.helloAgainSpring.entity.UserEntity;
import com.gmail.caioa.morais.helloAgainSpring.repository.UserRepository;
import com.gmail.caioa.morais.helloAgainSpring.security.JwtUtil;
import com.gmail.caioa.morais.helloAgainSpring.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @Override
    public TokenDTO login(AuthDTO authDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDTO.getUsername(),
                    authDTO.getPassword()));
        }

        catch (DisabledException | BadCredentialsException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid.credentials");
        }
        String token = jwtUtil.generateToken(authDTO.getUsername());
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);

        return tokenDTO;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(createUserDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        UserEntity savedUser = userRepository.save(userEntity);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setUsername(savedUser.getUsername());
        return userDTO;
    }
}
