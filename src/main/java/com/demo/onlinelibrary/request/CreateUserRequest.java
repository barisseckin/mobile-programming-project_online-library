package com.demo.onlinelibrary.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserRequest {

    @NotBlank
    private String username;
    @Email
    private String mail;
    @NotBlank
    private String password;
}
