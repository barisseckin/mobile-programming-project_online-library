package com.demo.onlinelibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String mail;
    private String password;
    private boolean isActive = false;

    @ManyToOne(cascade = CascadeType.ALL)
    private ImageFile imageFile;

    @ManyToOne
    private ConfirmCode confirmCode;

    public User(String username, String mail, String password, ImageFile imageFile) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.imageFile = imageFile;
    }
}
