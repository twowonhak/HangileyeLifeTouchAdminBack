package com.hangileye.lifetouch.service;

import com.hangileye.lifetouch.mapper.CommonMapper;
import com.hangileye.lifetouch.model.common.PatInfoModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CommonService {

    private final CommonMapper commonMapper;

    public CommonService(CommonMapper commonMapper) {
        this.commonMapper = commonMapper;
    }

    /*
     * @Description : 과 리스트 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> diagListSelect() {
        ResponseData res = new ResponseData();
        try {
            res.setData(commonMapper.diagListSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 환자 정보
     * */
    @Transactional
    public ResponseEntity<ResponseData> chartNoSelect(String chartNo) {
        ResponseData res = new ResponseData();
        try {

            PatInfoModel model = commonMapper.chartNoSelect(chartNo);

            if (model != null) {
                res.setData(model);
                res.setSuccess();
            } else {
                res.setErrNoData();
            }

            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 예약
     * */
    @Transactional
    public ResponseEntity<ResponseData> appointmentListSelect(String chartNo) {
        ResponseData res = new ResponseData();
        try {
            res.setData(commonMapper.appointmentListSelect(chartNo));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
