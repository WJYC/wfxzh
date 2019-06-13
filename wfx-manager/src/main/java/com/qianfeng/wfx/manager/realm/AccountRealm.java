package com.qianfeng.wfx.manager.realm;

import com.qianfeng.wfx.manager.user.bean.LoginUserBean;
import com.qianfeng.wfx.manager.user.service.IuserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AccountRealm extends AuthorizingRealm{

    @Resource
    private IuserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try{
            List<String> funcByUser = userService.queryFuncByUser(username);
            simpleAuthorizationInfo.addStringPermissions(funcByUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        char[] chars = usernamePasswordToken.getPassword();
        String password = new String(chars);

        LoginUserBean userInfo = userService.login(username, password);
        SecurityUtils.getSubject().getSession().setAttribute("user",userInfo);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "AccountRealm");

        return simpleAuthenticationInfo;
    }
}
