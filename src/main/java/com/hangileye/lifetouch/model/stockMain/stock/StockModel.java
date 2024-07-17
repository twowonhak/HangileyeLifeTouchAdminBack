package com.hangileye.lifetouch.model.stockMain.stock;

import com.hangileye.lifetouch.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * TB : TB_D001_STOCK
 * COMMENT : 재고관리
 * */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockModel extends BaseModel {
    private String  id;                 // 고유번호 (8)
    private String  key;                // 고유번호 (8)
    private String  assCd;              // 자산분류코드 (4)
    private String  assNm;              // 자산분류코드
    private String  assMainCd;          // 자산대분류코드 (2)
    private String  assMainNm;          // 자산대분류명
    private String  assSubCd;           // 자산중분류코드 (2)
    private String  assSubNm;           // 자산중분류명
    private String  buil;               // 건물
    private String  team;               // 부/팀
    private String  floor;              // 층
    private String  place;              // 상세위치
    private String  userNm;             // 소유주
    private String  year;               // 구입년도
    private String  ip;                 // IP
    private String  ms;                 // 오피스
    private String  hwp;                // 한글
    private String  useYn;              // 삭제여부
    private String  memo;               // 메모
    private String  crDtime;            // 등록일시
    private String  upDtime;            // 수정일
}
