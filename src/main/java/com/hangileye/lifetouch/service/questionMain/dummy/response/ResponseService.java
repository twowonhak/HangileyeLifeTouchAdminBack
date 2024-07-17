package com.hangileye.lifetouch.service.questionMain.dummy.response;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.response.ResponseMapper;
import com.hangileye.lifetouch.model.common.AppointmentModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class ResponseService extends ErrorHistory {

    private final ResponseMapper responseMapper;
    private final ErrorMapper errorMapper;

    public ResponseService(ResponseMapper responseMapper, ErrorMapper errorMapper) {
        this.responseMapper = responseMapper;
        this.errorMapper = errorMapper;
    }


    /*
     * @Description : 문진표 작성 여부 확인
     * */
    @Transactional
    public ResponseEntity<ResponseData> responseResultListSelect(HttpServletRequest request, AppointmentModel appointmentModel) {
        ResponseData res = new ResponseData();
        try {
            res.setData(responseMapper.responseResultListSelect(appointmentModel));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
