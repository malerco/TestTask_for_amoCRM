package ru.malerco.amocrm.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class CookieSaver implements CookieJar {
    private final HashMap<String, Cookie> authCookieStore = new HashMap<>();
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            if(cookie.name().equals("session_id"))authCookieStore.put(url.host(),cookie);
        }
    }



    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = new ArrayList<>();
        Cookie authCookie = authCookieStore.get(url.host());
        if (authCookie != null) {
            cookies.add(authCookie);
        }
        return cookies;
    }
}
