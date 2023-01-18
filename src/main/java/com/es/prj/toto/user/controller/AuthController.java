package com.es.prj.toto.user.controller;

import com.es.prj.toto.common.jwt.JwtProvider;
import com.es.prj.toto.user.domain.dto.UserDto;
import com.es.prj.toto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtProvider jwtProvider;
    private final UserService userService;

    @PostMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createToken(@RequestBody JSONObject obj) {
        String userId = obj.getString("userId");
        UserDto userInfo = userService.findUserInfo(userId);
        if(userInfo != null) {
            String token = jwtProvider.createToken(userId, Arrays.asList(userInfo.getUserType()));
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid UserId");
        }
    }
}
