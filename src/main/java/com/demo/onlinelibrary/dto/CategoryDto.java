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
public class CategoryDto {

    private String publicId;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
