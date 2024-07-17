package com.hangileye.lifetouch.service.questionMain;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.QueCodeMapper;
import com.hangileye.lifetouch.model.questionMain.QueCodeModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class QueCodeService extends ErrorHistory {

    private final QueCodeMapper queCodeMapper;
    private final ErrorMapper errorMapper;

    public QueCodeService(QueCodeMapper queCodeMapper, ErrorMapper errorMapper) {
        this.queCodeMapper = queCodeMapper;
        this.errorMapper = errorMapper;
    }

    public ResponseEntity<ResponseData> ctgListSelect(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            Map<Object, List<QueCodeModel>> map = new HashMap<>();
            map.put("lagCtg", queCodeMapper.lrgCtgListSelect());
            map.put("midCtg", queCodeMapper.midCtgListSelect());
            res.setData(map);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> lrgCtgInsert(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            queCodeMapper.lrgCtgInsert(queCodeModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> migCtgInsert(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            queCodeMapper.migCtgInsert(queCodeModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> lrgCtgUpdate(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            queCodeMapper.lrgCtgUpdate(queCodeModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> midCtgUpdate(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            queCodeMapper.midCtgUpdate(queCodeModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> lrgCtgDelete(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            queCodeMapper.lrgCtgDelete(queCodeModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> midCtgDelete(HttpServletRequest request, QueCodeModel queCodeModel) {
        ResponseData res = new ResponseData();
        try {
            queCodeMapper.midCtgDelete(queCodeModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> lrgCtgSortUpdate(HttpServletRequest request, List<QueCodeModel> queCodeModelList) {
        ResponseData res = new ResponseData();
        try {
            for (QueCodeModel queCodeModel : queCodeModelList) {
                queCodeMapper.lrgCtgSortUpdate(queCodeModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public ResponseEntity<ResponseData> midCtgSortUpdate(HttpServletRequest request, List<QueCodeModel> queCodeModelList) {
        ResponseData res = new ResponseData();
        try {
            for (QueCodeModel queCodeModel : queCodeModelList) {
                queCodeMapper.midCtgSortUpdate(queCodeModel);
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
