package com.project.hana_on_and_on_account_server.user.service;

import com.project.hana_on_and_on_account_server.common.util.JwtUtil;
import com.project.hana_on_and_on_account_server.user.domain.User;
import com.project.hana_on_and_on_account_server.user.dto.UserGetResponse;
import com.project.hana_on_and_on_account_server.user.dto.UserLoginRequest;
import com.project.hana_on_and_on_account_server.user.dto.UserLoginResponse;
import com.project.hana_on_and_on_account_server.user.exception.UserNotFoundException;
import com.project.hana_on_and_on_account_server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    public UserLoginResponse login(UserLoginRequest dto) {
        User loginUser = userRepository.findByPassword(dto.password()).orElseThrow(UserNotFoundException::new);
        String generatedAccessToken = jwtUtil.generateAccessToken(loginUser.getUserId());

        return new UserLoginResponse(generatedAccessToken);
    }

    public UserGetResponse findByUserId(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
        return UserGetResponse.fromEntity(user);
    }
}