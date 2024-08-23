package com.hangileye.lifetouch.service;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.LoginMapper;
import com.hangileye.lifetouch.model.ErrorModel;
import com.hangileye.lifetouch.model.LoginModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.CookieManager;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
public class LoginService extends ErrorHistory {

    private final LoginMapper loginMapper;
    private final ErrorMapper errorMapper;

    public LoginService(LoginMapper loginMapper, ErrorMapper errorMapper) {
        this.loginMapper = loginMapper;
        this.errorMapper = errorMapper;
    }

    /*
     * @Description : 관리자 로그인
     * */
    @Transactional
    public ResponseEntity<ResponseData> login(HttpServletResponse response, HttpServletRequest request, LoginModel loginModel) {
        ResponseData res = new ResponseData();
        try {
            LoginModel model = loginMapper.login(loginModel);
            // 로그인
            if (model != null) {
                res.setData(model);
                res.setSuccess();
                CookieManager.setCookie(response, "ID", model.getId());
                CookieManager.setCookie(response, "NAME", model.getName());
//                // 권한체크
//                if (loginMapper.loginRight(model.getId()) == 1) {
//                    log.info("로그인 성공");
//                    res.setData(model);
//                    res.setSuccess();
//                } else {
//                    res.setNoRight();
//                }
            } else {
                res.setNoLoginInfo();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
