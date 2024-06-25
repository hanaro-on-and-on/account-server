package com.project.hana_on_and_on_account_server.user.dto;

import com.project.hana_on_and_on_account_server.user.domain.User;

public record UserGetResponse(Long userId) {

    public static UserGetResponse fromEntity(User user){

        return new UserGetResponse(user.getUserId());
    }
}
