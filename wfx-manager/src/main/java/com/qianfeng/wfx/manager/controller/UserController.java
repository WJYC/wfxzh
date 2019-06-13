package com.qianfeng.wfx.manager.controller;

import com.qianfeng.wfx.manager.user.bean.LoginUserBean;
import com.qianfeng.wfx.manager.user.po.SysModule;
import com.qianfeng.wfx.manager.user.service.IuserService;
import com.qianfeng.wfx.manager.vo.JsonResult;
import com.qianfeng.wfx.manager.vo.ParentNodeVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IuserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public JsonResult login(String username, String password){

        JsonResult jsonResult = new JsonResult();
        try{
            UsernamePasswordToken token =new UsernamePasswordToken(username,password);
            SecurityUtils.getSubject().login(token);
            jsonResult.setCode(1);
        }catch (AuthenticationException e){
            e.printStackTrace();
            jsonResult.setCode(0);
        }
        return jsonResult;
    }

    @RequestMapping("/funcAll")
    public String queryFuncByRole(Model model)throws Exception{
        LoginUserBean user = (LoginUserBean) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<SysModule> funcAllList = userService.queryAllFunc(user.getRoleCode());
        List<SysModule> funcHasList = userService.queryFuncByRole(user.getRoleCode());
        model.addAttribute("allFuncList",funcAllList);
        model.addAttribute("funcHasList",funcHasList);
        return "permission";
    }

    @RequestMapping("/delfunc")
    @ResponseBody
    public JsonResult deleteFuncByCode(String[] moduleCode){

//        String[] strings = new String[1];
//        strings[0] = moduleCode;

        JsonResult jsonResult = new JsonResult();
        try {
            userService.deleteFuncByCode(moduleCode);
            jsonResult.setCode(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(0);
        }

        return jsonResult;
    }

    @RequestMapping("/addfunc")
    @ResponseBody
    public JsonResult addFunc(String[] moduleId,String roleId){

        JsonResult jsonResultVO = new JsonResult();
        try {
            for (int i=0;i< moduleId.length;i++) {
                userService.addFunc(moduleId[i], roleId);
            }

            jsonResultVO.setCode(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResultVO.setCode(0);
        }

        return jsonResultVO;
    }


    @RequestMapping("/parantNode")
    @ResponseBody
    public List<ParentNodeVO> queryParantNode(){
        LoginUserBean user = (LoginUserBean) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<ParentNodeVO> parentNodeVOS = userService.queryParantNode(user.getRoleCode());
        return parentNodeVOS;
    }

}
