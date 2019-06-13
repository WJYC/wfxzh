package com.qianfeng.wfx.manager.user.mapper;

import com.qianfeng.wfx.manager.user.bean.LoginUserBean;
import com.qianfeng.wfx.manager.user.po.SysModule;
import com.qianfeng.wfx.manager.vo.ParentNodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    LoginUserBean findByUserName(@Param("account") String account);
    List<SysModule> queryAllFunc();
    List<SysModule> queryFuncByRole(@Param("roleCode") String roleCode);
    List<String> queryNameFuncByRole(@Param("roleCode") String roleCode);
    void delFunByCode(String[] moduleCodes);
    void addFunc(@Param("moduleId") String moduleId,@Param("roleId") String roleId);
    List<ParentNodeVO> queryParentNode( @Param("roleCode") String roleCode);
    List<String> queryFuncByUser(@Param("username") String username);
}
