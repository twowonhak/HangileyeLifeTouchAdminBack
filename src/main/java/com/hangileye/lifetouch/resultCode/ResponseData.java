package com.hangileye.lifetouch.resultCode;

import lombok.Data;

@Data
public class ResponseData {

    private String resultCode;
    private String resultMessage;
    private Object data;

    // SUCCESS
    public void setSuccess() {
        resultCode = ResultEnum.SUCCESS.getCode();
        resultMessage = ResultEnum.SUCCESS.getMessage();
    }

    // 파라미터 오류입니다.
    public void setErrParam() {
        resultCode = ResultEnum.ERR_PARAM_.getCode();
        resultMessage = ResultEnum.ERR_PARAM_.getMessage();
    }

    // 잘못된 요청입니다.
    public void setErrBadRequest() {
        resultCode = ResultEnum.ERR_BAD_REQUEST.getCode();
        resultMessage = ResultEnum.ERR_BAD_REQUEST.getMessage();
    }

    // 로그인 정보가 없거나, ID 또는 PW가 잘못 되었습니다.
    public void setNoLoginInfo() {
        resultCode = ResultEnum.NO_LOGIN_INFO.getCode();
        resultMessage = ResultEnum.NO_LOGIN_INFO.getMessage();
    }

    // 해당 계정은 권한이 없습니다.
    public void setNoRight() {
        resultCode = ResultEnum.NO_RIGHT.getCode();
        resultMessage = ResultEnum.NO_RIGHT.getMessage();
    }

    // 조회된 데이터가 없습니다.
    public void setErrNoData() {
        resultCode = ResultEnum.ERR_NO_DATA.getCode();
        resultMessage = ResultEnum.ERR_NO_DATA.getMessage();
    }

    // 조회된 데이터가 없습니다.
    public void setErrNoChartNo() {
        resultCode = ResultEnum.ERR_NO_CHARTNO.getCode();
        resultMessage = ResultEnum.ERR_NO_CHARTNO.getMessage();
    }

    // 시스템 오류입니다. 고객센터로 문의해주세요.
    public void setSystem() {
        resultCode = ResultEnum.ERR_SYSTEM.getCode();
        resultMessage = ResultEnum.ERR_SYSTEM.getMessage();
    }

    // 토큰 정보가 없거나 유효기간이 만료되었습니다.
    public void setReToken() {
        resultCode = ResultEnum.ERR_AUTH_REFRESH_TOKEN.getCode();
        resultMessage = ResultEnum.ERR_AUTH_REFRESH_TOKEN.getMessage();
    }

    // 사용 중인 데이터 입니다. 삭제를 원하시면 사용 중인 데이터를 삭제 해주세요.
    public void setErrUse() {
        resultCode = ResultEnum.ERR_USE.getCode();
        resultMessage = ResultEnum.ERR_USE.getMessage();
    }

}
