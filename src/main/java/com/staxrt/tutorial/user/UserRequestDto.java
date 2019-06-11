package com.staxrt.tutorial.user;

import com.staxrt.tutorial.model.User;

public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String email;

    User toEntity(){
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }

}
