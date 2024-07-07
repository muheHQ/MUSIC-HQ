package com.hong.musichqend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.musichqend.constant.MessageConstant;
import com.hong.musichqend.exception.AccountFountException;
import com.hong.musichqend.exception.AccountNotFoundException;
import com.hong.musichqend.exception.GlobalException;
import com.hong.musichqend.exception.PasswordErrorException;
import com.hong.musichqend.mapper.UserMapper;
import com.hong.musichqend.pojo.DTO.RegisterDTO;
import com.hong.musichqend.pojo.DTO.UserDTO;
import com.hong.musichqend.pojo.entity.User;
import com.hong.musichqend.properties.JwtProperties;
import com.hong.musichqend.service.UserService;
import com.hong.musichqend.tools.JwtUtils;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.xml.namespace.QName;
import java.nio.channels.AcceptPendingException;
import java.util.HashMap;

/**
 * @Author HQ
 * @Date: 2024/7/6
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    public User login(UserDTO userDTO) {
        String name = userDTO.getName();
        String password = userDTO.getPassword();


        User user = userMapper.getByName(name);
        log.info("user:{}",user);

        if(user == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(user.getPassword())){
            log.info("password:{}",password);
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return user;
    }

    /**
     * 用户注册
     * @param registerDTO
     * @return
     */
    @Transactional
    public Boolean register(RegisterDTO registerDTO) {
        if(this.existUser(registerDTO.getName())){
            throw new AccountFountException(MessageConstant.ACCOUNT_FOUNT);
        }
        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            throw new RuntimeException(MessageConstant.PASSWORD_CONFIRM_ERROR);
        }
        String password = DigestUtils.md5DigestAsHex(registerDTO.getPassword().getBytes());
        User userRgister = User.builder()
                .name(registerDTO.getName())
                .password(password)
                .build();

        return userMapper.insert(userRgister) > 0;
    }

    /**
     * 判断当前用户是否存在
     * @param name
     * @return
     */
    private boolean existUser(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        return userMapper.selectCount(queryWrapper) > 0;
    }
}
