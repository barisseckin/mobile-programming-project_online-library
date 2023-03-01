package com.demo.onlinelibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class ConfirmCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int code = new Random().nextInt(999999999);
}
