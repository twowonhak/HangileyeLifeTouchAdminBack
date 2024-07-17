package com.hangileye.lifetouch.service.stockMain.asset;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.stockMain.asset.AssetMapper;
import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
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
public class AssetService extends ErrorHistory {

    private final AssetMapper assetMapper;
    private final ErrorMapper errorMapper;

    public AssetService(AssetMapper assetMapper, ErrorMapper errorMapper) {
        this.assetMapper = assetMapper;
        this.errorMapper = errorMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            res.setData(assetMapper.mainListSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 저장
     * */
    @Transactional
    public ResponseEntity<ResponseData> insert(HttpServletRequest request, AssetModel assetModel) {
        ResponseData res = new ResponseData();
        try {
            assetMapper.insert(assetModel);
            res.setData(assetMapper.mainListSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
