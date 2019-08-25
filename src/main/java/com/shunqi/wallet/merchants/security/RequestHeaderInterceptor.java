package com.shunqi.wallet.merchants.security;


import com.shunqi.wallet.merchants.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authorization interceptor
 */
@Component
public class RequestHeaderInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getHeader(Constants.TOKEN_STRING);

        // TODO: should assign a token to each merchant and validate in DB/by hashing
        if (StringUtils.isEmpty(token)) {
            throw new Exception("Missing token: " + Constants.TOKEN_STRING);
        }

        if (!token.equals(Constants.TOKEN)) {
            throw new Exception("Invalid token: " + Constants.TOKEN_STRING);
        }

        // set token to local thread
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) {
        AccessContext.clearAccessKey();
    }
}

