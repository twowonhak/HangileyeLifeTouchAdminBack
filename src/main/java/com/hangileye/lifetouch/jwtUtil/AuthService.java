package com.hangileye.lifetouch.jwtUtil;

import com.hangileye.lifetouch.model.TokensModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;
//    private final MailSenderUtil mailSenderUtil;

    /*
     * @Description : JWT 토큰 생성 후 신규 등록
     * */
    public TokensModel genTokens(String userId) {

        String accessToken = jwtProvider.createJwtToken("accessToken", userId);
        String refreshToken = jwtProvider.createJwtToken("refreshToken", userId);

        TokensModel res = TokensModel.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expireDt("1")
                .build();

        try {
            // 생성한 토큰 검증
            parseAccessToken(accessToken);
        } catch (Exception e) {
            log.error(e.toString());
            // 검증 오류나면 null 처리
        }

        return res;
    }

    /*
     * @Description : JWT 갱신
     * */
    public TokensModel refreshTokens(String userId) {

        String accessToken = jwtProvider.createJwtToken("accessToken", userId);
        String refreshToken = jwtProvider.createJwtToken("refreshToken", userId);

        TokensModel res = TokensModel.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expireDt("1")
                .build();

        try {
            // 생성한 토큰 검증
            parseAccessToken(accessToken);
        } catch (Exception e) {
            log.error(e.toString());
            // 검증 오류나면 null 처리
        }

        return res;
    }

    /*
     * @Description : ACCESS TOKEN 검증
     * */
    public String parseAccessToken(String accessToken) {

        String result = "";

        try {
            Jws<Claims> claimsJws = jwtProvider.parseJwtToken(accessToken);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date nowDate = new Date(System.currentTimeMillis());

            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("정보 (getBody) :  " + claimsJws.getBody());
            System.out.println("고유식별자 (getId) :  " + claimsJws.getBody().getId());
            System.out.println("청충 (getAudience) : " + claimsJws.getBody().getAudience());
            System.out.println("주제 (getSubject) : " + claimsJws.getBody().getSubject());
            System.out.println("발행인 (getIssuer) : " + claimsJws.getBody().getIssuer());
            System.out.println("방행일시 (getIssuedAt) : " + formatter.format(claimsJws.getBody().getIssuedAt()));
            System.out.println("만료일시 (getExpiration) : " + formatter.format(claimsJws.getBody().getExpiration()));

            if (nowDate.before(claimsJws.getBody().getExpiration())) {
                result = claimsJws.getBody().getIssuer();
            } else {
                System.out.println("토큰만료");
                result = null;
            }

            System.out.println("---------------------------------------------------------------------------------------------------------");

        } catch (ExpiredJwtException e) {
            log.error("parseAccessToken expired " + e.toString());
            log.error("parseAccessToken expired " + e.getClaims().toString());
            result = "expired";
        }

        return result;
    }

    /*
     * @Description : 토큰 복호화
     * */
    public String parseAccessTokenResult() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest(); // request 정보를 가져온다.

        String token = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();

                if (Objects.equals(name, "ACCESS_JWT")) {
                    token = parseAccessToken(value);
                }

                // 쿠키 이름과 값에 대한 처리
                System.out.println("CookieFun Name: " + name + ", Value: " + value);
            }
        }
//        log.info("token " + token);
        return token;
    }

    /*
     * @Description : 토큰 값 조회
     * */
    public String accessToken(ResponseData res) throws Exception {
        if (parseAccessTokenResult() == null || parseAccessTokenResult().equals("")) {
            throw new Exception("토큰 정보 없음");
        } else {
            return parseAccessTokenResult();
        }
    }


}
