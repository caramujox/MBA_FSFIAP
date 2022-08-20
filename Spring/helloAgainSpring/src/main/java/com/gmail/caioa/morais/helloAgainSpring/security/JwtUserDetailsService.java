package com.gmail.caioa.morais.helloAgainSpring.security;

import com.gmail.caioa.morais.helloAgainSpring.entity.UserEntity;
import com.gmail.caioa.morais.helloAgainSpring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findFirstByUserName(username);
        if(userEntity == null )
            throw new UsernameNotFoundException("user.not.found");
        return new User(userEntity.getUsername(), userEntity.getPassword(),
                new ArrayList<>());
    }

}
