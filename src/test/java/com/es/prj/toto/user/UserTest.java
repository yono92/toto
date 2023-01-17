package com.es.prj.toto.user;

import com.es.prj.toto.user.domain.UserRequest;
import com.es.prj.toto.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void userInfoInsert() {
        UserRequest request = new UserRequest();
        request.setUserId("test");
        request.setName("test");
        request.setPassword("test");
        request.setEmail("test@test.com");
        request.setPhone("01012341234");

        userService.insertUserInfo(request);
    }
}
