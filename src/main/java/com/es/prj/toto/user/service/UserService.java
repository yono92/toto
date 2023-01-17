package com.es.prj.toto.user.service;

import com.es.prj.toto.common.util.EncryptUtil;
import com.es.prj.toto.user.domain.UserRequest;
import com.es.prj.toto.user.entity.UserEntity;
import com.es.prj.toto.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserEntityRepository userEntityRepository;
    private final EncryptUtil encrypt;

    public void insertUserInfo(UserRequest userRequest) {
        try {
            UserEntity userEntity = UserEntity.builder()
                    .userId(userRequest.getUserId())
                    .name(userRequest.getName())
                    .password(encrypt.getEncryptValue(userRequest.getPassword(), userRequest.getUserId(), 100))
                    .email(userRequest.getEmail())
                    .phone(userRequest.getPhone())
                    .build();
            userEntityRepository.save(userEntity);
        } catch (Exception e) {
            log.error("encrypt Error : {},", userRequest);
            e.printStackTrace();
        }

    }

}
