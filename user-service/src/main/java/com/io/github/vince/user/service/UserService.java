package com.io.github.vince.user.service;

import com.io.github.vince.user.dto.LoginRequest;
import com.io.github.vince.user.dto.RegisterRequest;
import com.io.github.vince.user.entity.User;

public interface UserService {
    void register(RegisterRequest request);

    User login(LoginRequest request);

}
