package com.staxrt.tutorial.user;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}
