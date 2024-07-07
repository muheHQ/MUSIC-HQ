package com.hong.musichqend.controller;

import com.hong.musichqend.pojo.DTO.RegisterDTO;
import com.hong.musichqend.pojo.DTO.UserDTO;
import com.hong.musichqend.pojo.VO.UserVO;
import com.hong.musichqend.pojo.entity.User;
import com.hong.musichqend.properties.JwtProperties;
import com.hong.musichqend.service.UserService;
import com.hong.musichqend.tools.JwtUtils;
import com.hong.musichqend.tools.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author HQ
 * @Date: 2024/7/6
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Tag(name = "用户模块", description = "用户模块相关接口")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;


    @Operation(summary = "用户登录",description = "用户登录接口")
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody UserDTO userDTO){
        User user = userService.login(userDTO);

        // 登录成功 创建jwt令牌
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("username",userDTO.getName());
        String token = JwtUtils.createJWT(
                jwtProperties.getSecret(),
                jwtProperties.getExpirationTime(),
                claims
        );

        UserVO userLoginVO = UserVO.builder()
                .id(user.getId())
                .name(user.getName())
                .sex(user.getSex())
                .phone(user.getPhone())
                .email(user.getEmail())
                .introduction(user.getIntroduction())
                .avator(user.getAvator())
                .token(token)
                .build();

        return  Result.success(userLoginVO);
    }


    @Operation(summary = "用户注册",description = "用户注册接口")
    @PostMapping("/register")
    public void register(@RequestBody RegisterDTO registerDTO){
        userService.register(registerDTO);
    }
}
