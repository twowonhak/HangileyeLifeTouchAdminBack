package com.hangileye.lifetouch.model.common;

import lombok.Data;

/*
 * TB : TB_G044_APPOINTMENTEYE
 * COMMENT : 예약
 * */

@Data
public class AppointmentModel {

    private String seq;             // 순서
    private String chartNo;         // 차트번호
    private String appDat;          // 예약일자
    private String appDatDy;        // 예약일자
    private String appTime;         // 예약시간
    private String diagNm;          // 과명
    private String diagCd;          // 과코드
    private String doctNm;          // 의사명
    private String doctCd;          // 의사코드
    private String appoType;        // 예약구분
    private String appoNm;          // 예약구분 명
    private String vistYn;          // 방문여부
    private String queYn;           // 문진표 작성여부
    private String recvTm;
    private String type;
    private String vistDat;



}
