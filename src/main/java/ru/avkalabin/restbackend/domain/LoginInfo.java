package ru.avkalabin.restbackend.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginInfo {

    private String userName;
    private String password;

}
