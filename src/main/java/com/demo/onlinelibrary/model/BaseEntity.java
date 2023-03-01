package com.demo.onlinelibrary.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class BaseEntity {

    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate;
}
