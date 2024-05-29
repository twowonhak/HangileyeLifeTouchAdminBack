package com.hangileye.lifetouch.model;

import lombok.Data;

/*
 * TB : TB_F006_PATIENTCASE
 * COMMENT : 문진_환자케이스
 * */

@Data
public class PatientCaseModel {

    private String key;             // 키
    private String type;            // 진료타입(N:신환, F:초진, R:재진)
    private String diagCd;          // 진료과 코드
    private String sex;             // 성별(M:남자,F:여자)
    private String birth;           // 생년월일
    private String preYn;           // 임신 여부
    private String jobTy;           // 직업 타입
    private String pagtTy;          // 과거력 타입
    private String specialNote;     // 특이사항

    private String useStrDat;       // 적용 시작 일자
    private String useEndDat;       // 적용 종요 일자

    private String delYn;           // 삭제 여부
    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserNm;        // 등록 ID
    private String crUserIp;        // 등록 IP
    private String upDtime;         // 수정 일시
    private String upUserId;        // 수정 ID
    private String upUserNm;        // 수정 IP
    private String upUserIp;        // 수정 IP

    private String useDat;          // 조회 일자

}
