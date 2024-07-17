package com.hangileye.lifetouch.service.questionMain.dummy.patient;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.patient.SpecialNoteMapper;
import com.hangileye.lifetouch.model.questionMain.dummy.patient.SpecialNoteModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class SpecialNoteService extends ErrorHistory {

    private final SpecialNoteMapper specialNoteMapper;
    private final ErrorMapper errorMapper;

    public SpecialNoteService(SpecialNoteMapper specialNoteMapper, ErrorMapper errorMapper) {
        this.specialNoteMapper = specialNoteMapper;
        this.errorMapper = errorMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(HttpServletRequest request, SpecialNoteModel specialNoteModel) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, SpecialNoteModel specialNoteModel) {
        ResponseData res = new ResponseData();
        try {
            specialNoteMapper.insert(specialNoteModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 삭제
     * */
    @Transactional
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, SpecialNoteModel specialNoteModel) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
