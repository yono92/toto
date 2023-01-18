package com.es.prj.toto.user.controller;

import com.es.prj.toto.user.domain.request.UserRequest;
import com.es.prj.toto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApiController {
    private final UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean userLogin(@RequestBody UserRequest request) {
        return userService.validateUserInfo(request.getUserId(), request.getPassword());
    }

}
