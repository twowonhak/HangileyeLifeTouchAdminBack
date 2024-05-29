package com.hangileye.lifetouch.model;

import lombok.Data;

/*
 * TB : TB_F004_SpecialNoteNOTE
 * COMMENT : 문진_환자 특이사항
 * */

@Data
public class SpecialNoteModel {

    private String key;             // 키
    private String content;         // 특이사항 내용

    private String delYn;           // 삭제 여부

    private String diviceTy;
    private String osNm;
    private String browserNm;

    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserIp;        // 등록 IP
    private String crUserNm;        // 등록 이름
    private String upDtime;         // 수정일시
    private String upUserId;        // 수정ID
    private String upUserIp;        // 수정IP

}
