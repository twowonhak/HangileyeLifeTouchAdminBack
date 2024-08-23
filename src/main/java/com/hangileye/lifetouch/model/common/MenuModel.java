package com.hangileye.lifetouch.model.common;

import lombok.Data;

@Data
public class MenuModel {

    private String menuCd;
    private String menuNm;
    private String link;
    private String userId;

    private String[] menuArr;
}
