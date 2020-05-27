package com.pittacode.contapp.users.signup;

import com.pittacode.contapp.persistence.models.User;
import com.pittacode.contapp.users.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.pittacode.contapp.TestStringUtilities.generateRandomString;
import static org.assertj.core.api.Assertions.assertThat;

class SignUpServiceMapTest {

    private SignUpService classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new SignUpServiceMap();
    }

    @Test
    void shouldPersistAUserDto() {
        var userDto = buildUserDto();
        var persistedUser = User.builder()
                .alias(userDto.getAlias())
                .familyName(userDto.getFamilyName())
                .middleNames(userDto.getMiddleNames())
                .name(userDto.getName())
                .joinDate(userDto.getJoinDate())
                .build();
        persistedUser.setId(1L);

        var storedUser = classUnderTest.addUser(userDto);

        assertThat(storedUser).isEqualTo(persistedUser);
    }

    @Test
    void shouldIncreaseIdForNewEntity() {
        classUnderTest.addUser(buildUserDto());
        classUnderTest.addUser(buildUserDto());
        var storedUser3 = classUnderTest.addUser(buildUserDto());

        assertThat(storedUser3.getId()).isEqualTo(3);
    }

    private UserDto buildUserDto() {
        return UserDto.builder()
                .alias(generateRandomString())
                .familyName(generateRandomString())
                .middleNames(generateRandomString())
                .name(generateRandomString())
                .joinDate(LocalDate.now())
                .build();
    }
}