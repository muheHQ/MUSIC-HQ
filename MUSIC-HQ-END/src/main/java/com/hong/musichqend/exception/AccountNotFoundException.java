package com.hong.musichqend.exception;

import org.apache.ibatis.executor.BaseExecutor;

/**
 * @Author HQ
 * @Date: 2024/7/7
 */
public class AccountNotFoundException extends BaseException {
    public AccountNotFoundException(){

    }

    public AccountNotFoundException(String message) {
        super(message);
    }

}
