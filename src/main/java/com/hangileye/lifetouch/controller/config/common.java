package com.hangileye.lifetouch.controller.config;


import com.hangileye.lifetouch.utill.InetAddressInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/common")
public class common {

    /*
     * @Author : 이원학
     * @Since : 2023.11.01
     * @Description : ip 불러오기
     * @Param :
     * @Return :
     * @Exception :
     * */
    @GetMapping("/ipInfo")
    public String ipInfo() {
//        String ip = InetAddressInfo.getServerIp();
        String ip = InetAddressInfo.getClientIP();
        log.info("ipInfo");
        log.info(ip);
        return ip;
    }
}
