package com.hong.musichqend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.musichqend.pojo.DTO.RegisterDTO;
import com.hong.musichqend.pojo.DTO.UserDTO;
import com.hong.musichqend.pojo.entity.User;
import jakarta.servlet.http.HttpSession;

/**
 * @Author HQ
 * @Date: 2024/7/6
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param userDTO
     * @return
     */
    User login(UserDTO userDTO);

    /**
     * 注册
     * @param registerDTO
     * @return
     */
    Boolean register(RegisterDTO registerDTO);
}
