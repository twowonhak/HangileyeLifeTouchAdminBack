package com.hangileye.lifetouch.service.stockMain.asset;

import com.hangileye.lifetouch.mapper.stockMain.asset.AssetMapper;
import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AssetService {

    private final AssetMapper assetMapper;

    public AssetService(AssetMapper assetMapper) {
        this.assetMapper = assetMapper;
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect() {
        ResponseData res = new ResponseData();
        try {
            res.setData(assetMapper.mainListSelect());
            res.setSuccess();
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
    public ResponseEntity<ResponseData> insert(AssetModel assetModel) {
        ResponseData res = new ResponseData();
        try {
            assetMapper.insert(assetModel);
            res.setData(assetMapper.mainListSelect());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
