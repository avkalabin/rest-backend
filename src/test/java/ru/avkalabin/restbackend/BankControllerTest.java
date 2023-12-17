package ru.avkalabin.restbackend;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import ru.avkalabin.restbackend.domain.UserInfo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
public class BankControllerTest {

    @Test
    void bankControllerTest() {

         RequestSpecification requestSpec = with()
                .log().all()
                .contentType(JSON)
                .baseUri("http://localhost:8080")
                .basePath("/user");

      UserInfo[] userInfos =  given(requestSpec)
                .when()
                .get("/getAll")
                .then()
                .statusCode(200)
                .log().all()
                .contentType(JSON)
                .extract()
                .response()
                .as(UserInfo[].class);

        Stream.of(userInfos)
                .filter(userInfo -> userInfo.getUserName().equals("Alex"))
                .peek(userInfo -> System.out.println(userInfo.getUserName()))
                .map(UserInfo::toString)
                .collect(Collectors.toList());

    }
}
