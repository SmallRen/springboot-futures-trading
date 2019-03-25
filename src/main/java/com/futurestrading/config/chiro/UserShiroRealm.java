package com.futurestrading.config.chiro;

import com.futurestrading.entity.User;
import com.futurestrading.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserShiroRealm extends AuthenticatingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserShiroRealm.class);
    @Autowired
    IUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        User user = userService.getUser(username);
        if (user != null) {
            //2). credentials: 密码.
            Object credentials = user.getPassword();
            Object principal = user.getUsername();
            //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
            String realmName = getName();
            //4). 盐值.
            ByteSource credentialsSalt = ByteSource.Util.bytes(username);
            SimpleAuthenticationInfo info = null;
            info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
            return info;
        }
        return null;

    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object salt = ByteSource.Util.bytes("admin");
        Object credentials = "123456";

        ;
        int hashIterations = 2;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}