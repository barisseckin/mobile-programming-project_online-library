package com.demo.onlinelibrary.utils.converter;

import com.demo.onlinelibrary.dto.UserDto;
import com.demo.onlinelibrary.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    private final ImageFileDtoConverter imageFileDtoConverter;

    public UserDtoConverter(ImageFileDtoConverter imageFileDtoConverter) {
        this.imageFileDtoConverter = imageFileDtoConverter;
    }

    public UserDto toDto(User from) {
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.getPassword(),
                from.isActive(),
                imageFileDtoConverter.toDto(from.getImageFile()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
