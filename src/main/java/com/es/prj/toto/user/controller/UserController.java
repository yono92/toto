package com.es.prj.toto.user.controller;

import com.es.prj.toto.user.domain.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    @PostMapping(value = "/join", produces = MediaType.APPLICATION_JSON_VALUE)
    public void userJoin(@RequestBody UserRequest userRequest) {

    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView userLogin(ModelAndView mv) {
        mv.setViewName("/login");



        return mv;
    }


    @GetMapping(value = "/withdraw/{userId}")
    public void userWithdraw(@PathVariable String userId) {

    }
}
