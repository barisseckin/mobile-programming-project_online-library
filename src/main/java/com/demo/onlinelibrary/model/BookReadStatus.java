package com.demo.onlinelibrary.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum BookReadStatus {
    ADDED,
    READING,
    READ
}
