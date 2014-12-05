package com.june.controller;

import org.apache.shiro.SecurityUtils;

import com.june.service.user.ShiroDbRealm.ShiroUser;

public class BaseController {

    protected Long getCurrentUserId() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}
