package com.io.github.vince.user.controller;

import com.io.github.vince.user.common.Result;
import com.io.github.vince.user.dto.LoginRequest;
import com.io.github.vince.user.dto.RegisterRequest;
import com.io.github.vince.user.entity.User;
import com.io.github.vince.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user/hello")
    public Result<String> hello() {
        return Result.success("Hello from user-service");
    }

    @PostMapping("/register")
    public Result<String> register(@Valid @RequestBody RegisterRequest request) {
        userService.register(request);
        return Result.success();
    }

    // 登录
    @PostMapping("/login")
    public Result<User> login(@Valid @RequestBody LoginRequest request) {
        User user = userService.login(request);
        // 这里简单返回消息，实际可以返回用户信息或 token
        user.setPassword(null);
        return Result.success(user);
    }
}
