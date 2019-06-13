package com.qianfeng.wfx.manager.user.service;

import com.qianfeng.wfx.manager.user.bean.LoginUserBean;
import com.qianfeng.wfx.manager.user.po.SysModule;
import com.qianfeng.wfx.manager.vo.ParentNodeVO;
import org.apache.shiro.authc.AuthenticationException;

import java.util.List;

public interface IuserService {
    LoginUserBean login(String username, String password)throws NullPointerException, AuthenticationException;
    List<SysModule> queryAllFunc(String roleCode)throws Exception;
    List<SysModule> queryFuncByRole( String roleCode)throws Exception;
//    List<String> queryNameFuncByRole()throws Exception;
    void deleteFuncByCode(String[] moduleCode) throws Exception;
    void addFunc(String moduleId,String roleId) throws Exception;
    List<ParentNodeVO> queryParantNode( String roleCode);
    List<String> queryFuncByUser( String username)  ;
}
