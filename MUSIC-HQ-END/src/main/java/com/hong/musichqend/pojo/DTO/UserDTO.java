package com.hong.musichqend.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HQ
 * @Date: 2024/7/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private String password;
    private Integer sex;
    private String phone;
    private String address;
    private String email;
    private String introduction;
    private String avator;

}
