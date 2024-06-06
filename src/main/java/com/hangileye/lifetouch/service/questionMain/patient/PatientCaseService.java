package com.hangileye.lifetouch.service.questionMain.patient;

import com.hangileye.lifetouch.mapper.CodeMapper;
import com.hangileye.lifetouch.mapper.questionMain.patient.PatientCaseMapper;
import com.hangileye.lifetouch.model.questionMain.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.common.CodeModel;
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
public class PatientCaseService {

    private final PatientCaseMapper patientCaseMapper;
    private final CodeMapper codeMapper;

    public PatientCaseService(PatientCaseMapper patientCaseMapper, CodeMapper codeMapper) {
        this.patientCaseMapper = patientCaseMapper;
        this.codeMapper = codeMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(String useDat) {
        ResponseData res = new ResponseData();
        try {

            List<PatientCaseModel> list = patientCaseMapper.listSelect(useDat);
            List<CodeModel> code = codeMapper.diag();

//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).getDiagCd() != null) {
//                    String model = list.get(i).getDiagCd();
//                    for (CodeModel obj : code) {
//                        model = model.replace(obj.getCode(), obj.getName());
//                    }
//                    list.get(i).setDiagCd(model);
//                }
//
//                if (list.get(i).getType() != null) {
//
//                }
//
//                if (list.get(i).getSex() != null) {
//
//                }
//
//                if (list.get(i).getBirth() != null) {
//
//                }
//
//
//            }

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
    public ResponseEntity<ResponseData> detailSelect(String key) {
        ResponseData res = new ResponseData();
        try {
            PatientCaseModel model = patientCaseMapper.detailSelect(key);
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
    public ResponseEntity<ResponseData> insert(PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            patientCaseMapper.insert(patientCaseModel);
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
    public ResponseEntity<ResponseData> delete(PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            if (patientCaseMapper.caseUse(patientCaseModel.getKey()) == 1) {
                res.setErrUse();
                return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
            } else {
                patientCaseMapper.delete(patientCaseModel);
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
     * @Description : 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> update(PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            patientCaseMapper.update(patientCaseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

}
