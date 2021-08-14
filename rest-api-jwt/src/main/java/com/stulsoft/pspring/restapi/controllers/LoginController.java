/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pspring.restapi.controllers;

import com.stulsoft.pspring.restapi.data.Token;
import com.stulsoft.pspring.restapi.security.jwt.JwtUtils;
import com.stulsoft.pspring.restapi.security.service.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Yuriy Stul
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/api/auth/login")
    public Token login() {
        logger.info("==>login");
        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return UserDetailsImpl.build();
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "ys.test";
            }
        };

        try {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            logger.debug("jwt: {}", jwt);
            return new Token(jwt);
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
            return new Token(null);
        }
    }
}
