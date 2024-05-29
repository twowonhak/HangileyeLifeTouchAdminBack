package com.hangileye.lifetouch.model;

import lombok.Data;

/*
 * TB : TB_F007_QUESTIONEXAMPLECASE
 * COMMENT : 문진_질문_보기_케이스
 * */

@Data
public class QuestionExampleCaseModel {

    private String key;             // 키
    private String queKey;          // 질문 키
    private String queTxt;          // 질문 내용
    private String queSort;         // 질문 순서||
    private String exaKey;          // 보기 키
    private String exaTy;           // 타입 [ T : 프리 텍스트 / R : 라디오 버튼 ]
    private String exaTxt;          // 보기 내용
    private String exaSort;         // 보기 순서

    private String useStrDay;       // 적용 시작 일자
    private String useEndDay;       // 적용 종요 일자

    private String delYn;           // 삭제 여부
    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserIp;        // 등록 IP
    private String delDtime;        // 삭제 일시
    private String delUserId;       // 삭제 ID
    private String delUserIp;       // 삭제 IP

}
