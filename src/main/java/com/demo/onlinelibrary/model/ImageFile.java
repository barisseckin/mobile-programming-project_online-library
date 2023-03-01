package com.demo.onlinelibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageFile extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicId = UUID.randomUUID().toString();
    private String fileType;
    private Long fileSize;
    private String fileName;

    @Lob
    private byte[] data;

    public ImageFile(String fileType, Long fileSize, String fileName, byte[] data) {
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.data = data;
    }
}
