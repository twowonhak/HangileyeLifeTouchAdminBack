package com.hangileye.lifetouch.service.questionMain.response;

import com.hangileye.lifetouch.mapper.questionMain.response.ResponseMapper;
import com.hangileye.lifetouch.model.common.AppointmentModel;
import com.hangileye.lifetouch.model.common.PatInfoModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ResponseService {

    private final ResponseMapper responseMapper;

    public ResponseService(ResponseMapper responseMapper) {
        this.responseMapper = responseMapper;
    }


    /*
     * @Description : 문진표 작성 여부 확인
     * */
    @Transactional
    public ResponseEntity<ResponseData> responseResultListSelect(AppointmentModel appointmentModel) {
        ResponseData res = new ResponseData();
        try {
            res.setData(responseMapper.responseResultListSelect(appointmentModel));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
