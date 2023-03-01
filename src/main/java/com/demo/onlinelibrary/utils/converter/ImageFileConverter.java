package com.demo.onlinelibrary.utils.converter;

import com.demo.onlinelibrary.dto.ImageFileDto;
import com.demo.onlinelibrary.model.ImageFile;
import org.springframework.stereotype.Component;

@Component
public class ImageFileConverter {

    public ImageFileDto toDto(ImageFile from) {
        return new ImageFileDto(
                from.getPublicId(),
                from.getFileName(),
                from.getFileSize(),
                from.getFileType(),
                from.getData(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
