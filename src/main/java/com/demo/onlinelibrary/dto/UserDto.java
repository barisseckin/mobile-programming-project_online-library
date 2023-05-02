package com.demo.onlinelibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDto {

    private String username;
    private String mail;
    private String password;
    private boolean isActive;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
