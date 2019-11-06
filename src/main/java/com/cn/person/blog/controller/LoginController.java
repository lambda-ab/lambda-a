package com.cn.person.blog.controller;

import com.cn.person.blog.constant.CommonConstant;
import com.cn.person.blog.entity.LoginParam;
import com.cn.person.blog.entity.ResultVo;
import com.cn.person.blog.entity.sys.SysUser;
import com.cn.person.blog.service.sys.SysOperateLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author moment
 * @date 2019/10/24 10:16
 * @describe
 */
@RestController
@CrossOrigin
public class LoginController extends BaseController {
    @Autowired
    SysOperateLogService sysOperateLogService;


    @RequestMapping("loginOut")
    public ResultVo loginOut() {
        ResultVo resultVo = new ResultVo();
        SysUser user = getSysUser();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        sysOperateLogService.save(this.getClass().getName(), "loginOut", user);
        return resultVo;
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultVo login(@RequestBody LoginParam loginParam) {
        ResultVo resultVo = new ResultVo();
//        if (!LoginParam.LOGIN_TYPE_ADMIN.equals(loginParam.getLoginType())) {
//            validateCheckCode(loginParam.getPicCode());
//        }
//        //处理传入参数  验证码-  校验密码强度-
//        UsernamePasswordToken token = new UsernamePasswordToken(loginParam.getAccount(), loginParam.getPassword());
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//        } catch (IncorrectCredentialsException e) {
//            resultVo.setCode(ResultVo.ERROR_CODE);
//            resultVo.setMsg(CommonConstant.ACCOUNT_OR_PASSWORD_ERROR);
//            return resultVo;
//        } catch (DisabledAccountException e) {
//            resultVo.setCode(ResultVo.ERROR_CODE);
//            resultVo.setMsg(CommonConstant.ACCOUNT_NOT_EXIST_OR_STOP);
//            return resultVo;
//        } catch (Exception e) {
//            resultVo.setCode(ResultVo.ERROR_CODE);
//            resultVo.setMsg(CommonConstant.SYSTEM_ERROR);
//            return resultVo;
//        }
//        SysUser user = (SysUser) subject.getPrincipal();
//        setSessionAttribute(CommonConstant.USER_KEY, user);
//        sysOperateLogService.save(this.getClass().getName(),"login",user);
        resultVo.setCode(ResultVo.SUCCESS_CODE);
        resultVo.setMsg(CommonConstant.REQ_CN_SUCCESS);
        resultVo.setData("52858585");
        return resultVo;
    }

    private ResultVo validateCheckCode(String checkCode) {
        ResultVo resultVo = new ResultVo();
        if (StringUtils.isBlank(checkCode)) {
            resultVo.setCode(ResultVo.ERROR_CODE);
            resultVo.setMsg(CommonConstant.CHECK_CODE_NULL);
            resultVo.setData(CommonConstant.CHECK_CODE_NULL);
        } else {
            String sessionCheckCode = (String) getSessionAttribute(CommonConstant.CHECK_CODE);
            if (!sessionCheckCode.equals(checkCode)) {
                resultVo = new ResultVo();
                resultVo.setCode(ResultVo.ERROR_CODE);
                resultVo.setMsg(CommonConstant.CHECK_CODE_ERROR);
                resultVo.setData(CommonConstant.CHECK_CODE_ERROR);
            } else {
                resultVo = new ResultVo();
                resultVo.setCode(ResultVo.SUCCESS_CODE);
                resultVo.setMsg(CommonConstant.CHECK_CODE_SUCCESS);
                resultVo.setData(CommonConstant.CHECK_CODE_SUCCESS);
            }
        }
        return resultVo;
    }


}
