package com.itrjp.seckill.vo;/**
 * Created by renjp on 2019/1/24.
 */

import javax.validation.constraints.NotNull;

/**
 * @author renjp
 * @Date 2019/1/24 10:47
 * @Version 1.0
 */
public class LoginVo {
    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
