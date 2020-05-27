package com.pittacode.contapp.users.signup;

import com.pittacode.contapp.persistence.models.User;
import com.pittacode.contapp.users.UserDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.max;

@Service
@Profile({"default", "map"})
public class SignUpServiceMap implements SignUpService {

    private final Map<Long, User> userRepository;

    public SignUpServiceMap() {
        userRepository = new HashMap<>();
    }

    @Override
    public User addUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        userRepository.put(user.getId(), user);
        return user;
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
                .id(generateId())
                .build();
    }

    private Long generateId() {
        return userRepository.isEmpty()
                ? 1
                : max(userRepository.keySet()) + 1;
    }
}
