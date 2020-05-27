package com.pittacode.contapp.users.signup;

import com.pittacode.contapp.persistence.models.User;
import com.pittacode.contapp.persistence.repositories.UserRepository;
import com.pittacode.contapp.users.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SignUpServiceJpaTest {

    private SignUpService classUnderTest;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        classUnderTest = new SignUpServiceJpa(userRepository);
    }

    @Test
    void shouldPersistAUserDto() {
        var now = LocalDate.now();
        var userDto = UserDto.builder()
                .alias("alias")
                .familyName("family-name")
                .middleNames("middle-names")
                .name("name")
                .joinDate(now)
                .build();
        var persistedUser = User.builder()
                .alias("alias")
                .familyName("family-name")
                .middleNames("middle-names")
                .name("name")
                .joinDate(now)
                .build();

        classUnderTest.addUser(userDto);

        var captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());
        assertThat(captor.getValue()).isEqualTo(persistedUser);
    }

}