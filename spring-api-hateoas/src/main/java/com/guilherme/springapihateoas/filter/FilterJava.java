package com.guilherme.springapihateoas.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FilterJava implements Filter {
    private Logger logger = LoggerFactory.getLogger(FilterJava.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("There's someone at the castle gate.");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        Map<String, String> mapHeaders = Collections.list(headerNames)
                .stream()
                .collect(Collectors.toMap(it -> it, httpServletRequest::getHeader));
        if(mapHeaders.get("authorization") != null && mapHeaders.get("authorization") .equalsIgnoreCase("Melko")) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendError(403);
        }

        logger.info("Closed the castle gate.");
    }
}
