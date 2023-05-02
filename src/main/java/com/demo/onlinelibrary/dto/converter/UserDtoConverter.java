package com.demo.onlinelibrary.dto.converter;

import com.demo.onlinelibrary.dto.UserDto;
import com.demo.onlinelibrary.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto toDto(User from) {
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.getPassword(),
                from.isActive(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
