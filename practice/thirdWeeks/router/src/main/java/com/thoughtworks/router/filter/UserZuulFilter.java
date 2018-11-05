package com.thoughtworks.router.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.thoughtworks.router.login.JwtUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserZuulFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("------------------"+user.getUsername());
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("userId",String.valueOf(user.getId()));
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
