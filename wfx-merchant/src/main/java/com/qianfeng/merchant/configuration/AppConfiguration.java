package com.qianfeng.merchant.configuration;


import com.qianfeng.merchant.realm.AccountRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class AppConfiguration {

    @Bean
    public DefaultWebSecurityManager provideSecuretyManager(AccountRealm accountRealm){
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
            securityManager.setRealm(accountRealm);
            return securityManager;
    }


    @Bean
    public ShiroFilterFactoryBean provideShiroFilter(DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();

        shiroFilterFactoryBean.setLoginUrl("/page/login.html");
//        不需要登录认证的页面，不拦截
        linkedHashMap.put("/page/login.html","anon");
        linkedHashMap.put("/customer/login","anon");
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/css/**","anon");
        // 定义拦截规则，拦截所有，都需要登录认证
        linkedHashMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public DefaultAdvisorAutoProxyCreator provideDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        return autoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor provideAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager SecurityManager){
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        attributeSourceAdvisor.setSecurityManager(SecurityManager);
        return attributeSourceAdvisor;
    }

}
