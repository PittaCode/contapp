package com.pittacode.contapp.users.signup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pittacode.contapp.users.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SignUpControllerTest {

    private MockMvc mockMvc;

    private SignUpService signUpService;

    private SignUpController classUnderTest;

    @BeforeEach
    void setUp() {

        signUpService = mock(SignUpServiceJpa.class);

        classUnderTest = new SignUpController(signUpService);

        mockMvc = MockMvcBuilders.standaloneSetup(classUnderTest).build();
    }

    @ParameterizedTest
    @EnumSource(value = HttpMethod.class,
                names = {"POST", "OPTIONS", "TRACE"},
                mode = EnumSource.Mode.EXCLUDE)
    void shouldRejectAllMethodsExceptPost(HttpMethod requestMethod) throws Exception {
        var requestBuilder = MockMvcRequestBuilders.request(requestMethod, SignUpController.PATH);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isMethodNotAllowed())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    void shouldCallServiceWithRequestBody() throws Exception {
        var userDto = UserDto.builder()
                .alias("alias")
                .familyName("family-name")
                .middleNames("middle-names")
                .name("name")
                .build();
        var requestBuilder = MockMvcRequestBuilders.request(HttpMethod.POST, SignUpController.PATH)
                .content(new ObjectMapper().writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.log());

        verify(signUpService).addUser(userDto);
    }

}