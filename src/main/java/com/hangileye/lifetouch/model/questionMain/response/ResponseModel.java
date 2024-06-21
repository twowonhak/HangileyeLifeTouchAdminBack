package com.hangileye.lifetouch.model.questionMain.response;

import lombok.Data;

/*
 * TB : TB_F008_RESPONSE
 * COMMENT : 문진_답변
 * */

@Data
public class ResponseModel {

    private String chartNo;             // 차트번호
    private String appDat;              // 예약 일자
    private String diagCd;              // 진료과 코드
    private String diagNm;              // 진료의 이름
    private String doctCd;              // 진료과 코드
    private String doctNm;              // 진료의 이름
    
    private String patCase;             // 환자 케이스 키
    private String key;                 // 질문 키
    private String queTxt;              // 질문 내용
    private String exaKey;              // 보기 키
    private String exatype;             // 타입 [ T : 텍스트 / C : 체크박스  ]
    private String exaTxt;              // 보기 내용
    private String resTxt;              // 답변 내용

    private String diviceTy;
    private String osNm;
    private String browserNm;
    private String appoType;            // 예약구분 (01-진료예약 , 02-PRP , 03-망막YAG , 04-PDT , 05-전안부Laser , 06-주사예약 , 07-시간외예약 , 08-FAG/ICG , 09-시야검사 , 10-ERG/VEP/EOG)
    private String appoNm;              // 예약구분 명

    private String crDiviceTy;          // 등록 운영체제
    private String crOsNm;              // 등록 브라우저정보
    private String crbrowserNm;         // 등록 브라우저정보
    private String crDtime;             // 등록 일시
    private String crUserIp;            // 등록 IP

}
