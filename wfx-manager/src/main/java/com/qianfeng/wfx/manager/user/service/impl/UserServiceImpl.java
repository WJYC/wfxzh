package com.qianfeng.wfx.manager.user.service.impl;

import com.qianfeng.wfx.manager.user.bean.LoginUserBean;
import com.qianfeng.wfx.manager.user.mapper.UserMapper;
import com.qianfeng.wfx.manager.user.po.SysModule;
import com.qianfeng.wfx.manager.user.service.IuserService;
import com.qianfeng.wfx.manager.vo.ParentNodeVO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IuserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public void deleteFuncByCode(String[] moduleCode) throws Exception {
        userMapper.delFunByCode(moduleCode);
    }

    @Override
    public void addFunc(String moduleId, String roleId) throws Exception {
        userMapper.addFunc(moduleId,roleId);
    }

    @Override
    public List<ParentNodeVO> queryParantNode(String roleCode) {
        List<ParentNodeVO> parentNodeVOS = userMapper.queryParentNode(roleCode);
        return parentNodeVOS;
    }

    @Override
    public List<String> queryFuncByUser(String username) {
        List<String> modules = userMapper.queryFuncByUser(username);
        return modules;
    }


    @Override
    public LoginUserBean login(String username, String password)throws NullPointerException, AuthenticationException {
        if(username==null){
            throw new NullPointerException("username is null");
        }
        if(password==null){
            throw new NullPointerException("password is null");
        }
        LoginUserBean userInfo = userMapper.findByUserName(username);
        if(userInfo==null){
            throw new UnknownAccountException();
        }

        String salt = userInfo.getAccount() + userInfo.getUserId();
        //MD5加密
        Md5Hash md5Hash = new Md5Hash(password,salt);
        String hex = md5Hash.toHex();
        //数据库查询到的密文
        String infoPassword = userInfo.getPassword();
        if(!infoPassword.equals(hex)){
            throw new IncorrectCredentialsException();
        }
        return userInfo;
    }

    @Override
    public List<SysModule> queryAllFunc( String roleCode) throws Exception {
        List<SysModule> moduleList = userMapper.queryAllFunc();
        List<String> stringList =userMapper.queryNameFuncByRole(roleCode);
        ArrayList<SysModule> arrayList = new ArrayList<>();

            for(int i=0;i<moduleList.size();i++){
                    if(!stringList.contains(moduleList.get(i).getModuleCode())){
                        arrayList.add(moduleList.get(i));
                    }
            }

        return arrayList;
    }

    @Override
    public List<SysModule> queryFuncByRole(String roleCode) throws Exception {
        List<SysModule> modules = userMapper.queryFuncByRole(roleCode);
        return modules;
    }


}
