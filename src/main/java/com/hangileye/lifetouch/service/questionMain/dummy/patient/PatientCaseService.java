package com.hangileye.lifetouch.service.questionMain.dummy.patient;

import com.hangileye.lifetouch.mapper.CodeMapper;
import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.patient.PatientCaseMapper;
import com.hangileye.lifetouch.mapper.questionMain.dummy.queCase.CaseMapper;
import com.hangileye.lifetouch.model.questionMain.dummy.patient.PatientCaseModel;
import com.hangileye.lifetouch.model.common.CodeModel;
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
public class PatientCaseService extends ErrorHistory {

    private final PatientCaseMapper patientCaseMapper;
    private final CaseMapper caseMapper;
    private final CodeMapper codeMapper;
    private final ErrorMapper errorMapper;

    public PatientCaseService(PatientCaseMapper patientCaseMapper, CaseMapper caseMapper, CodeMapper codeMapper, ErrorMapper errorMapper) {
        this.patientCaseMapper = patientCaseMapper;
        this.caseMapper = caseMapper;
        this.codeMapper = codeMapper;
        this.errorMapper = errorMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, String useDat) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 상세 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(HttpServletRequest request, String key) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            patientCaseMapper.insert(patientCaseModel);
            res.setData(caseMapper.keySelect(patientCaseModel));
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
    public ResponseEntity<ResponseData> delete(HttpServletRequest request, PatientCaseModel patientCaseModel) {
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
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> update(HttpServletRequest request, PatientCaseModel patientCaseModel) {
        ResponseData res = new ResponseData();
        try {
            patientCaseMapper.update(patientCaseModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
