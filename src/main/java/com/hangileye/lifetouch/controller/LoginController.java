package com.hangileye.lifetouch.controller;

import com.hangileye.lifetouch.model.LoginModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    /*
     * @Description : 관리자 로그인
     * */
    @RequestMapping("/loginApi")
    public ResponseData login(HttpServletResponse response, HttpServletRequest request, @RequestBody LoginModel loginModel) {
        return loginService.login(response, request, loginModel).getBody();
    }

}
