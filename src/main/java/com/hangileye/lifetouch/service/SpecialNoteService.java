package com.hangileye.lifetouch.service;

import com.hangileye.lifetouch.mapper.SpecialNoteMapper;
import com.hangileye.lifetouch.model.SpecialNoteModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class SpecialNoteService {

    private final SpecialNoteMapper specialNoteMapper;

    public SpecialNoteService(SpecialNoteMapper specialNoteMapper) {
        this.specialNoteMapper = specialNoteMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect() {
        ResponseData res = new ResponseData();
        try {
            List<SpecialNoteModel> list = specialNoteMapper.listSelect();
            if (list.size() == 0) {
                res.setErrNoData();
            } else {
                res.setData(list);
                res.setSuccess();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(SpecialNoteModel specialNoteModel) {
        ResponseData res = new ResponseData();
        try {
            SpecialNoteModel model = specialNoteMapper.detailSelect(specialNoteModel);
            if (model == null) {
                res.setErrNoData();
            } else {
                res.setData(model);
                res.setSuccess();
            }
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(SpecialNoteModel specialNoteModel) {
        ResponseData res = new ResponseData();
        try {
            specialNoteMapper.insert(specialNoteModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> delete(SpecialNoteModel specialNoteModel) {
        ResponseData res = new ResponseData();
        try {
            if (specialNoteMapper.specialNoteUse(specialNoteModel.getKey()) == 1) {
                res.setErrUse();
                return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
            } else {
                specialNoteMapper.delete(specialNoteModel);
                List<SpecialNoteModel> list = specialNoteMapper.listSelect();
                if (list.size() == 0) {
                    res.setErrNoData();
                } else {
                    res.setData(list);
                    res.setSuccess();
                }
                return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
