package com.hangileye.lifetouch.model;

import lombok.Data;

/*
 * TB : TB_F005_CASE
 * COMMENT : 문진_케이스
 * */

@Data
public class CaseModel {

    private String patKey;      // 환자 케이스 키
    private String queKey;      // 질문 키
    private String exaKey;      // 보기 키

    private String delYn;       // 삭제 여부
    private String diviceTy;    // 등록 디바이스정보
    private String osNm;        // 등록 운영체제
    private String browserNm;     // 등록 브라우저정보
    private String crdTime;     // 등록 일시
    private String crUserIp;    // 등록 IP

}
