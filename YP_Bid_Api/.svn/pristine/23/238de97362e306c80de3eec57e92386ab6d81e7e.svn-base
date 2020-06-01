package com.yuepeng.base.interceptor;


import com.yuepeng.base.annotation.Login;
import com.yuepeng.base.config.JwtConfig;
import com.yuepeng.dispose.common.RCode;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.utils.RTProperties;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 *
 * @author
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private final JwtConfig jwtConfig;

    @Value("${token.ignore:false}")
    private boolean tokenIgnore;

    public AuthorizationInterceptor(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }

        if (tokenIgnore) {
            return true;
        }
        //获取用户凭证
        String token = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(jwtConfig.getHeader());
        }

        //凭证为空
        if (StringUtils.isBlank(token)) {
            throw new RRException(RCode.TOKEN_EMPTY);
        }

        Claims claims = jwtConfig.getClaimByToken(token);
        if (claims == null || jwtConfig.isTokenExpired(claims.getExpiration())) {
            throw new RRException(RCode.TOKEN_PAST);
        }

        //设置 identityId 用户身份ID
        request.setAttribute(RTProperties.USER_KEY, Integer.parseInt(claims.getSubject()));
        RTProperties.currUser.set(claims.getSubject());

        return true;
    }

}
