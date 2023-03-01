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
public class ImageFileDto {

    private String publicId;
    private String fileName;
    private Long fileSize;
    private String fileType;
    private byte[] data;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
