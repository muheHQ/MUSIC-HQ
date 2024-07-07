package com.hong.musichqend.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HQ
 * @Date: 2024/7/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private String name;
    private String password;
    private String confirmPassword;
    private String email;
}
