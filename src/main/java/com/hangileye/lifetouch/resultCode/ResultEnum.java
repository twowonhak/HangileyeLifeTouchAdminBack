package com.hangileye.lifetouch.resultCode;

// 코드 / 메세지
public enum ResultEnum implements Codable {


    SUCCESS("0000", "SUCCESS"),
    ERR_PARAM_("4001", "파라미터 오류입니다."),
    ERR_BAD_REQUEST("4400", "잘못된 요청입니다."),
    NO_LOGIN_INFO("2001", "로그인 정보가 없거나, ID 또는 PW가 잘못 되었습니다."),
    NO_RIGHT("2002", "해당 계정은 권한이 없습니다."),
    ERR_NO_DATA("2000", "조회된 데이터가 없습니다."),
    ERR_NO_CHARTNO("2100", "입력 하신 정보의 차트번호와 URL KEY 값이 일치 하지 않습니다."),
    ERR_USE("2200", "사용 중인 데이터 입니다. 삭제를 원하시면 사용 중인 데이터를 삭제 해주세요."),

    ERR_SYSTEM("9999", "시스템 오류입니다.\n고객센터로 문의해주세요."),
    ERR_AUTH_REFRESH_TOKEN("1000", "토큰 정보가 없거나 유효기간이 만료되었습니다.");

    private final String resultCode;
    private final String resultMessage;

    private ResultEnum(String code, String message) {
        this.resultCode = code;
        this.resultMessage = message;
    }

    @Override
    public String getCode() {
        return resultCode;
    }


    @Override
    public String getMessage(String... args) {
        return parseMessage(resultMessage, args);
    }

    public String parseMessage(String message, String... args) {
        if (message == null || message.trim().length() <= 0) {
            return message;
        }

        if (args == null || args.length <= 0) {
            return message;
        }

        String[] splitMsgs = message.split("%");

        if (splitMsgs.length <= 1) {
            return message;
        }

        for (int i = 0; i < args.length; i++) {
            String replaceChar = "%" + (i + 1);
            message = message.replaceFirst(replaceChar, args[i]);
        }

        return message;
    }
};
