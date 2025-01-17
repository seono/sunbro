package com.humorpage.sunbro.provider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieProvider {
    public static Cookie createCookie(String cookieName, String value){
        Cookie token = new Cookie(cookieName,value);
        token.setHttpOnly(true);
        token.setMaxAge((int)JwtTokenProvider.AccesstokenValidMilisecond);
        token.setPath("/");
        return token;
    }

    public static Cookie getCookie(HttpServletRequest req, String cookieName){
        final Cookie[] cookies = req.getCookies();
        if(cookies==null) return null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(cookieName))
                return cookie;
        }
        return null;
    }
}
