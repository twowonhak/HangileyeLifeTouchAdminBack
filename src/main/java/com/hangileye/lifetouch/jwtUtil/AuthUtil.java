package com.hangileye.lifetouch.jwtUtil;

import com.hangileye.lifetouch.model.TokensModel;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthUtil {



    // 토큰 생성 후 유저 쿠키 저장
    public static void setJwtCookie(HttpServletResponse response, TokensModel tokensModel, String userId) {

        /*
            보안 위해 리프레시 토큰만 쿠키에 저장
            액세스 토큰은 다른곳 local storage 혹은 js private variable 에 저장

            액세스 토큰이 유효하면 요청에 대한 응답을 내려주고
            액세스 토큰이 없거나 만료등으로 유효하지 않다면 쿠키의 리프레시 토큰을 조회해서 액세스 토큰을 재발행해서 내려줌

            리프레시 토큰은 회원가입/로그인시 발행

            다중로그인 처리 가능?

            굳이 리프레시토큰이 필요한가

            액세스토큰 하나만 쿠키에 저장해놓고
            모든 요청시 쿠키에서 액세스토큰 비교해서 사용하면 되지 않나...

            다른 개발자들은
            액세스 토큰을 매요청시 헤더에 포함해 보내고
            액세스 토큰 검증 실패시 리프레시 토큰을
            리프레시토큰은 쿠키등에
         */


        try{
            Cookie myCookie = new Cookie("ACCESS_JWT", tokensModel.getAccessToken() );
            myCookie.setMaxAge(1000 * 3600 * 24 * 30);
//            myCookie.setMaxAge(60 * 60);
            myCookie.setHttpOnly(false);    // js에서 쿠키 접근 불가시 true
            myCookie.setSecure(false);      // https 에서만 접근 가능시 true
            myCookie.setPath("/"); // 모든 경로에서 접근 가능 하도록 설정
            response.addCookie(myCookie);

            myCookie = new Cookie("REFRESH_JWT", tokensModel.getRefreshToken() );
//            myCookie.setMaxAge(60 * 60);
            myCookie.setMaxAge(1000 * 3600 * 24 * 30);
            myCookie.setHttpOnly(false);    // js에서 쿠키 접근 불가시 true
            myCookie.setSecure(false);      // https 에서만 접근 가능시 true
            myCookie.setPath("/"); // 모든 경로에서 접근 가능 하도록 설정
            response.addCookie(myCookie);

        }catch (Exception e){
            log.error("setJwtCookie " + e);
        }

    }

}
