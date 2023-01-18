package com.es.prj.toto.user.controller;

import com.es.prj.toto.common.contents.Authority;
import com.es.prj.toto.user.domain.request.UserRequest;
import com.es.prj.toto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/join")
    public String userJoin() {
        return "/member/join";
    }

    @PostMapping(value = "/join", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userJoin(@RequestBody UserRequest userRequest, Model model) {
        userService.insertUserInfo(userRequest);
        model.addAttribute("userId", userRequest.getUserId());
        return "/user/join_complete";
    }

    @GetMapping(value = "/login")
    public String userLogin() {
        return "/user/login";
    }

    @GetMapping(value = "/withdraw/{userId}")
    public void userWithdraw(@PathVariable String userId) {

    }
}
