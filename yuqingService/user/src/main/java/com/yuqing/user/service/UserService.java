package com.yuqing.user.service;

import com.yuqing.user.bean.ChangePasswordUser;
import com.yuqing.user.bean.User;

import java.util.List;

public interface UserService {
    String changePassword(ChangePasswordUser user);

    User showCurUserInfo(ChangePasswordUser user);
}
