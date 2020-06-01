package com.yuepeng.base.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.utils.IPUtils;
import com.yuepeng.utils.IdGen;
import com.yuepeng.utils.RTProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LogAspect {

    public static final String POST = "POST";
    public static final String GET = "GET";

    @Pointcut("@annotation(com.yuepeng.base.annotation.ApiLog)")
    public void logPointCut (){

    }

    @Around("logPointCut()")
    public Object around (ProceedingJoinPoint point) throws Throwable {
        Object result = null ;
        String uniqueCode =  IdGen.getUniqueCode();
        try{
            // 执行方法
            result = point.proceed();
            // 保存请求日志
            saveRequestLog(point, uniqueCode, result);
        } catch (Exception e){
            // 保存异常日志
            saveExceptionLog(point, e, uniqueCode);
            throw e;
        }
        return result;
    }


    private void saveExceptionLog (ProceedingJoinPoint point, Exception ex, String uniqueCode){
        printMsg(point, uniqueCode, null);
        log.error("[{}]捕获异常: {}", uniqueCode, ex.getMessage(), ex);
    }

    private void printMsg(ProceedingJoinPoint point, String uniqueCode, Object result) {
        String currUser = RTProperties.currUser.get();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("[{}]请求IP: {}", uniqueCode, IPUtils.getIpAddress(request));
        log.info("[{}]请求路径: {}", uniqueCode, request.getRequestURL());
        if(StringUtils.isNotBlank(currUser)){
            log.info("[{}]请求用户: {}", uniqueCode, currUser);
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        log.info("[{}]请求方法: {}", uniqueCode, method.getName());
        // 获取方法上ApiLog注解
        ApiLog apiLog = method.getAnnotation(ApiLog.class);
        String value = apiLog.value() ;
        log.info("[{}]模块描述: {}", uniqueCode, value);
        String methodType = request.getMethod();
        if(POST.equalsIgnoreCase(methodType)){
            Object[] args = point.getArgs();
            log.info("[{}]请求参数: {}", uniqueCode, JSON.toJSONString(args, SerializerFeature.IgnoreNonFieldGetter));
        }else{
            Map<String, String[]> parameterMap = request.getParameterMap();
            log.info("[{}]请求参数: {}", uniqueCode, JSON.toJSONString(parameterMap, SerializerFeature.IgnoreNonFieldGetter));
        }

        if(null != result){
            log.info("[{}]响应结果: {}", uniqueCode, JSON.toJSON(result));
        }
    }


    private void saveRequestLog (ProceedingJoinPoint point, String uniqueCode, Object result){
        printMsg(point, uniqueCode, result);
    }

}
