package com.es.prj.toto.user.controller;

import com.es.prj.toto.user.domain.UserRequest;
import com.es.prj.toto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/join", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userJoin(@RequestBody UserRequest userRequest, Model model) throws Exception {
        userService.insertUserInfo(userRequest);
        model.addAttribute("userId", userRequest.getUserId());
        return "/user/join_complete";
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView userLogin(ModelAndView mv) {



        return mv;
    }


    @GetMapping(value = "/withdraw/{userId}")
    public void userWithdraw(@PathVariable String userId) {

    }
}
