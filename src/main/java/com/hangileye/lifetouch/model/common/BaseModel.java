package com.hangileye.lifetouch.model.common;

import com.hangileye.lifetouch.utill.InetAddressInfo;
import lombok.Data;


@Data
public class BaseModel {

    private String delYn;           // 삭제 여부
    private String crDtime;         // 등룍 일시
    private String crUserId;        // 등록 ID
    private String crUserIp;        // 등록 IP
    private String crUserNm;        // 등록 이름
    private String upDtime;         // 삭제 일시
    private String upUserId;        // 삭제 ID
    private String upUserIp;        // 삭제 IP
    private String upUserNm;        // 삭제 IP

    public BaseModel() {
        this.crUserIp = InetAddressInfo.getClientIP();
        this.upUserIp = InetAddressInfo.getClientIP();
    }

}
