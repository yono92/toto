package com.es.prj.toto.user.service;

import com.es.prj.toto.common.util.EncryptUtil;
import com.es.prj.toto.user.domain.dto.UserDto;
import com.es.prj.toto.user.domain.request.UserRequest;
import com.es.prj.toto.user.entity.UserEntity;
import com.es.prj.toto.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
                    .password(encrypt.getEncryptValue(userRequest.getPassword(), userRequest.getUserId()))
                    .email(userRequest.getEmail())
                    .phone(userRequest.getPhone())
                    .build();
            userEntityRepository.save(userEntity);
        } catch (Exception e) {
            log.error("encrypt Error : {},", userRequest);
            e.printStackTrace();
        }

    }

    public UserDto findUserInfo(String userId) {
        Optional<UserEntity> userInfo = userEntityRepository.findById(userId);
        UserDto userDto = new UserDto();
        if(userInfo.isPresent()) {
            userDto.builder()
                    .userId(userInfo.get().getUserId())
                    .userType(userInfo.get().getUserType())
                    .build();
        }
        return userDto;
    }


    public Boolean validateUserInfo(String userId, String password) {
        Boolean validate = false;
        Optional<UserEntity> userInfo = userEntityRepository.findById(userId);
        try {
            String encodePwd = encrypt.getEncryptValue(password, userId);
            if(encodePwd.equals(userInfo.get().getPassword())) {
                validate = true;
            }
        } catch (Exception e) {
            log.error("validateUserInfo encrypt Error");
        }
        return validate;
    }

}
