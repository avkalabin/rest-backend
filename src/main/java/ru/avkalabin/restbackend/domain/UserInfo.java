package ru.avkalabin.restbackend.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

public class UserInfo {

    private Date loginDate;
    private String userName;
}
