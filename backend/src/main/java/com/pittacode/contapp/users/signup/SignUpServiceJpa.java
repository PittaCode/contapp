package com.pittacode.contapp.users.signup;

import com.pittacode.contapp.persistence.users.User;
import com.pittacode.contapp.persistence.users.UserRepository;
import com.pittacode.contapp.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("data-jpa")
public class SignUpServiceJpa implements SignUpService {

    private final UserRepository userRepository;

    @Autowired
    public SignUpServiceJpa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        return userRepository.save(user);
    }

    private User convertToEntity(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("User DTO is null");
        }

        return User.builder()
                .alias(userDto.getAlias())
                .familyName(userDto.getFamilyName())
                .middleNames(userDto.getMiddleNames())
                .name(userDto.getName())
                .joinDate(userDto.getJoinDate())
                .build();
    }
}
