package com.pittacode.contapp.users.signup;

import com.pittacode.contapp.persistence.users.User;
import com.pittacode.contapp.users.UserDto;

public interface SignUpService {
    User addUser(UserDto userDto);
}
