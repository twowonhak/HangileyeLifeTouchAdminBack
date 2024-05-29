package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.LoginModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    /*
     * @Description : 관리자 로그인
     * */
    LoginModel login(LoginModel loginModel);


    /*
     * @Description : 권한체크
     * */
    int loginRight(String id);
}
