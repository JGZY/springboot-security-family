package com.wj.springsecurity.util;

import com.wj.springsecurity.domain.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static Authentication getActiveAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户
     */
    public static SysUser getActiveUser() {
        return (SysUser ) getActiveAuthentication().getPrincipal();
    }

    public static String getActiveAccount(){
        return getActiveUser().getUsername();
    }
}
