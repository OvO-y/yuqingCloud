package com.yvqing.loginregister.converter;


import com.yuqing.user.bean.User;
import com.yvqing.loginregister.dto.LoReDto;

/**
 * LoReConverter class.
 *
 * @author Administrator
 * @since 2025/2/12
 */
public class LoReConverter {
    // Class implementation goes here
    public static LoReDto convertToUserDto(User user) {
        LoReDto loReDto = new LoReDto();

        loReDto.setAccount(user.getAccount());
        loReDto.setTelephone(user.getTelephone());

        System.out.println("test convert" + loReDto.getResp());
        return loReDto;
    }
}
