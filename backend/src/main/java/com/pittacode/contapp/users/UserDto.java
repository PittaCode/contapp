package com.pittacode.contapp.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class UserDto {

    private String name;

    private String familyName;

    private String middleNames;

    private String alias;

    private LocalDate joinDate;
}
