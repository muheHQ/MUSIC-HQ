package com.hong.musichqend.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HQ
 * @Date: 2024/7/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Integer id;
    private String name;
    private Integer sex;
    private String phone;
    private String email;
    private String introduction;
    private String avator;
    private String token;
}
