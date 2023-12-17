package ru.avkalabin.restbackend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.avkalabin.restbackend.domain.LoginInfo;
import ru.avkalabin.restbackend.domain.UserInfo;
import ru.avkalabin.restbackend.exception.InvalidUsernameException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private final Map<String, UserInfo> users = Map.of(
            "Semen", UserInfo.builder().userName("Semen").build(),
            "Alex", UserInfo.builder().userName("Alex").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build()

    );

    @PostMapping("user/login")
    @ApiOperation("Авторизация")
    public UserInfo doLogin (@RequestBody LoginInfo loginInfo) {
      if (loginInfo.getUserName().equals("Semen")) {
            return UserInfo
                    .builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
          throw new InvalidUsernameException();
      }
    }

    @GetMapping("user/getAll")
    @ApiOperation("Получение всех пользователей")
    public List<UserInfo> getAllUsersInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


}
