package com.ggk.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreRequestFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
		
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
