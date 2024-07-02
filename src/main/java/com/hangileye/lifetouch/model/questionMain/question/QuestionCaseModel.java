package com.hangileye.lifetouch.model.questionMain.question;

import lombok.Data;

import java.util.ArrayList;

/*
 * TB : TB_F007_QUESTIONCASE
 * COMMENT : 문진_질문_케이스
 * */

@Data
public class QuestionCaseModel {

    private String key;             // 키

    private String content;         // 내용
    private String sort;            // 순서
    private String exampleArr;    // 보기들
    
    private String useStrDat;       // 적용 시작 일자
    private String useEndDat;       // 적용 종요 일자

    private String delYn;           // 삭제 여부
    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserIp;        // 등록 IP
    private String crUserNm;        // 등록 이름
    private String upDtime;        // 삭제 일시
    private String upUserId;       // 삭제 ID
    private String upUserIp;       // 삭제 IP
    private String upUserNm;       // 삭제 IP

}
