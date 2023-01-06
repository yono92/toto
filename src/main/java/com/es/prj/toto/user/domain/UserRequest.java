package com.es.prj.toto.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phone;
}
