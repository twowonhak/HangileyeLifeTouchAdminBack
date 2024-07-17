package com.hangileye.lifetouch.model.questionMain.dummy.queCase;

import lombok.Data;

/*
 * TB : TB_F005_CASE
 * COMMENT : 문진_케이스
 * */

@Data
public class CaseModel {

    private String patKey;          // 환자 케이스 키
    private String queKey;          // 질문 키
    private String key;             // 질문 키

    private String[] queKeyArr;     // 질문 키
    private String sort;            // 순서
    private String content;         // 내용

    private String delYn;           // 삭제 여부
    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserNm;        // 등록자
    private String crUserIp;        // 등록 IP
    private String upDtime;         // 수정 일시
    private String upUserId;        // 수정 ID
    private String upUserNm;        // 수정자
    private String upUserIp;        // 수정 IP

}
