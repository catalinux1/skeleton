package com.skeleton.mapper;

import com.skeleton.entity.User;
import com.skeleton.model.UserModel;

public class UserMapper {
    public static UserModel entityToModel (final User user) {
        return UserModel.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}