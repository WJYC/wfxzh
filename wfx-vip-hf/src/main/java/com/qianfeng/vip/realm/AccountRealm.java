package com.qianfeng.vip.realm;

import com.qianfeng.vip.po.WxbMemeber;
import com.qianfeng.vip.service.IMemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AccountRealm extends AuthorizingRealm{

    @Resource
    private IMemberService memberService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        char[] chars = usernamePasswordToken.getPassword();
        String password = new String(chars);

        try {
            WxbMemeber wxbMemeber = memberService.querayByName(username, password);
            SecurityUtils.getSubject().getSession().setAttribute("wxbMemeber",wxbMemeber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "AccountRealm");

        return simpleAuthenticationInfo;
    }
}
