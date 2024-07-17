package com.hangileye.lifetouch.model;

import com.hangileye.lifetouch.utill.CookieManager;
import com.hangileye.lifetouch.utill.InetAddressInfo;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public class ErrorModel {

    private String api;
    private String error;
    private String id;
    private String ip;

    public ErrorModel(HttpServletRequest request) {
        this.api = request.getRequestURI();
        this.id = CookieManager.getCookie(request, "ID") != null ? CookieManager.getCookie(request, "ID") : "";
        this.ip = InetAddressInfo.getClientIP();
    }

}
