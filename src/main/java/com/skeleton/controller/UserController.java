package com.skeleton.controller;

import com.skeleton.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @NonNull
    private final UserService userService;

    @GetMapping(value = "/list")
    public String getList(final Model model) {
        model.addAttribute("userModel", userService.getUserModelList());

        return "userManagement/list";
    }
}