package com.cn.person.blog.config.aop;

import com.alibaba.fastjson.JSONObject;
import com.cn.person.blog.constant.CommonConstant;
import com.cn.person.blog.entity.sys.SysRequestLog;
import com.cn.person.blog.entity.sys.SysUser;
import com.cn.person.blog.service.sys.SysRequestLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author moment
 * @date 2019/10/14 17:49
 * @describe
 */
@Aspect
@Component
public class RequestLogAspect {
    @Autowired
    private SysRequestLogService sysRequestLogService;

    /**
     * Pointcut 定义Pointcut，Pointcut的名称为aspectjMethod()，此方法没有返回值和参数
     * 该方法就是一个标识，不进行调用
     */
    @Pointcut("execution(* com.cn.person.blog.controller..*.*(..))")
    private void aspectjMethod() {
        String str = "";
        if (str != null) {
        }
    }

    /**
     * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "aspectjMethod()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        Object resultObj = pjp.proceed();
        long end = System.currentTimeMillis();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String userId = "";

        HttpSession session = request.getSession();
        try {
            Object userObject = session.getAttribute(CommonConstant.USER_KEY);
            if (null != userObject) {
                SysUser user = (SysUser) userObject;
                userId = user.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String httpMethod = request.getMethod();
        String requestURI = request.getRequestURI();
        String isAjax = "";
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            isAjax = "Y";
        } else {
            isAjax = "N";
        }
        String requestMethod = pjp.toString();
        String requestParameter = JSONObject.toJSONString(request.getParameterMap());

        SysRequestLog sysLog = new SysRequestLog();
        sysLog.setRemoteAddr(remoteAddr);
        sysLog.setRemoteHost(remoteHost);
        sysLog.setHttpMethod(httpMethod);
        sysLog.setRequestUri(requestURI);
        sysLog.setIsAjax(isAjax);
        sysLog.setRequestMethod(requestMethod);
        sysLog.setRequestParameter(requestParameter);
        sysLog.setLogType("0");
        sysLog.setUserId(userId);
        sysLog.setUseTime(end - start);
        String outMsg = resultObj == null ? "" : resultObj.toString();
        if (outMsg.length() > 4000) {
            sysLog.setResult(outMsg.substring(0, 4000));
        } else {
            sysLog.setResult(outMsg);
        }
        sysRequestLogService.save(sysLog);
        return resultObj;
    }


}
