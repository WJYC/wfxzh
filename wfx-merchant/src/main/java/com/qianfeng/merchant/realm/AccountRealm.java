package com.qianfeng.merchant.realm;

import com.qianfeng.merchant.po.WxbCustomer;
import com.qianfeng.merchant.service.IWxbCustomerService;
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
    private IWxbCustomerService wxbCustomerService;

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

        WxbCustomer customer = wxbCustomerService.findByLoginName(username, password);
        SecurityUtils.getSubject().getSession().setAttribute("customer",customer);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "AccountRealm");

        return simpleAuthenticationInfo;
    }
}
