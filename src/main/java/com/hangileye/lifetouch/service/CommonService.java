package com.hangileye.lifetouch.service;

import com.hangileye.lifetouch.mapper.CommonMapper;
import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.model.common.MenuModel;
import com.hangileye.lifetouch.model.common.PatInfoModel;
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
public class CommonService extends ErrorHistory {

    private final CommonMapper commonMapper;
    private final ErrorMapper errorMapper;

    public CommonService(CommonMapper commonMapper, ErrorMapper errorMapper) {
        this.commonMapper = commonMapper;
        this.errorMapper = errorMapper;
    }

    @Transactional
    public ResponseEntity<ResponseData> mainMenuSelect(HttpServletRequest request, MenuModel menuModel) {
        ResponseData res = new ResponseData();
        try {
            res.setData(commonMapper.mainMenuSelect(menuModel));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 과 리스트 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> diagListSelect(HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            res.setData(commonMapper.diagListSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 환자 정보
     * */
    @Transactional
    public ResponseEntity<ResponseData> chartNoSelect(HttpServletRequest request, String chartNo) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 예약
     * */
    @Transactional
    public ResponseEntity<ResponseData> appointmentListSelect(HttpServletRequest request, String chartNo) {
        ResponseData res = new ResponseData();
        try {
            res.setData(commonMapper.appointmentListSelect(chartNo));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }


}
