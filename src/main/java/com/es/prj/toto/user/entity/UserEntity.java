package com.es.prj.toto.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member", schema = "totoga")
public class UserEntity {
    @Id
    String userId;

    @Column(name = "user_name", length = 10, nullable = false)
    String name;
    @Column(name = "user_pwd", length = 65, nullable = false)
    String password;
    @Column(name = "user_email", length = 30, nullable = false)
    String email;
    @Column(name = "user_phone", length = 15, nullable = false)
    String phone;
    @Column(name = "user_type", length = 10, nullable = false)
    String userType;
    @Column(name = "regdate", nullable = false)
    LocalDate regDate;
    @Column(name = "modidate")
    LocalDate modiDate;

    //default value 추가
    @PrePersist
    public void reset() {
        this.userType = this.userType == null ? "USER" : this.userType;
        this.regDate = LocalDate.now();
    }
}
