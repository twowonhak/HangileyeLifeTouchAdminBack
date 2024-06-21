package com.hangileye.lifetouch.model.common;

import lombok.Data;

@Data
public class PatInfoModel {

    private String chartNo;     // 차트번호
    private String patNm;       // 이름
    private String sex;         // 성별
    private String age;         // 나이
    private String birth;       // 생년월일
    private String postNo;      // 우편번호
    private String telNo;       // 전화번호
    private String mobNo;       // 휴대번호
    private String inSuCls;     // 보혐유형 대분류
    private String inSuSub;     // 보혐유형 소분류

}
