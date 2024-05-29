package com.hangileye.lifetouch.model;

import lombok.Data;

/*
 * 관리자 페이지 로그인
 * */

@Data
public class LoginModel {

    private String id;          // 사번
    private String pw;          // 비밀번호
    private String name;        // 이름
    private String dept;        // 부서명
    private String loginIp;     // ip

}
