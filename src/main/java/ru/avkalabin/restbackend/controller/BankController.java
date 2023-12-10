package ru.avkalabin.restbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.avkalabin.restbackend.domain.LoginInfo;
import ru.avkalabin.restbackend.domain.UserInfo;

import java.util.Date;

@RestController
public class BankController {

    @PostMapping("user/login")
    public UserInfo doLogin (@RequestBody LoginInfo loginInfo) {
      if (loginInfo.getUserName().equals("Andrei")) {
            return UserInfo
                    .builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build;
        }
        return null;
    }


}
