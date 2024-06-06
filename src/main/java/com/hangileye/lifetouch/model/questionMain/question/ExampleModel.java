package com.hangileye.lifetouch.model.questionMain.question;

import lombok.Data;

/*
 * TB : TB_F008_EXAMPLE
 * COMMENT : 문진_보기
 * */

@Data
public class ExampleModel {

    private String key;             // 키
    private String queKey;          // 질문키

    private String type;            // 타입 [ T : 프리 텍스트 / C : 체크박스  ]
    private String content;         // 질문 내용
    private String sort;            // 질문 순서

    private String delYn;           // 삭제 여부
    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserIp;        // 등록 IP
    private String crUserNm;        // 등록 이름
    private String upDtime;         // 삭제 일시
    private String upUserId;        // 삭제 ID
    private String upUserIp;        // 삭제 IP
    private String upUserNm;        // 삭제 IP

}
