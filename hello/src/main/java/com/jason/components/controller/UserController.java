package com.jason.components.controller;

import com.jason.components.service.UserService;
import com.jason.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by BNC on 2019/5/30.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    public MessageDTO getUserInfo(@RequestParam String userId) {
        return userService.findUserInfo(userId);
    }

    @GetMapping("/userDetail")
    public MessageDTO getUserDetail(@RequestParam String userId) {
        return userService.findUserDetail(userId);
    }
}
