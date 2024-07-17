package com.hangileye.lifetouch.utill;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.model.ErrorModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class ErrorHistory {

    public ResponseEntity<ResponseData> errorHistory(HttpServletRequest request, ResponseData res, ErrorMapper errorMapper, Exception e) {
        log.error(String.valueOf(e));
        ErrorModel errorModel = new ErrorModel(request);
        errorModel.setError(String.valueOf(e));
        errorMapper.insertErrorHis(errorModel);
        res.setSystem();
        return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
