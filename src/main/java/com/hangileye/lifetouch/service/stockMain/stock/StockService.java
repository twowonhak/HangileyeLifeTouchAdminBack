package com.hangileye.lifetouch.service.stockMain.stock;

import com.hangileye.lifetouch.mapper.stockMain.asset.AssetMapper;
import com.hangileye.lifetouch.mapper.stockMain.stock.StockMapper;
import com.hangileye.lifetouch.model.stockMain.stock.StockModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class StockService {

    private final StockMapper strockMapper;
    private final AssetMapper assetMapper;


    public StockService(StockMapper strockMapper, AssetMapper assetMapper) {
        this.strockMapper = strockMapper;
        this.assetMapper = assetMapper;
    }

    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {
            res.setData(strockMapper.listSelect(stockModel));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 공통코드
     * */
    @Transactional
    public ResponseEntity<ResponseData> cdListSelect() {
        ResponseData res = new ResponseData();
        try {
            Map map = new HashMap<>();
            map.put("assetMain", assetMapper.mainListSelect());
            map.put("assetSub", assetMapper.subListSelect());
            map.put("team", strockMapper.teamListSelect());
            map.put("code", strockMapper.codeListSelect());
            res.setData(map);
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
    public ResponseEntity<ResponseData> insert(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {
            strockMapper.insert(stockModel);
            res.setData(stockModel.getId());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(String id) {
        ResponseData res = new ResponseData();
        try {
            res.setData(strockMapper.detailSelect(id));
            res.setSuccess();
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
    public ResponseEntity<ResponseData> update(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {

            if (stockModel.getBuil() == null)
                stockModel.setBuil("");

            if (stockModel.getTeam() == null)
                stockModel.setTeam("");

            if (stockModel.getFloor() == null)
                stockModel.setFloor("");

            if (stockModel.getPlace() == null)
                stockModel.setPlace("");

            if (stockModel.getUserNm() == null)
                stockModel.setUserNm("");

            if (stockModel.getIp() == null)
                stockModel.setIp("");

            if (stockModel.getYear() == null)
                stockModel.setYear("");

            if (stockModel.getHwp() == null)
                stockModel.setHwp("");

            if (stockModel.getMs() == null)
                stockModel.setMs("");

            if (stockModel.getMemo() == null)
                stockModel.setMemo("");

            strockMapper.update(stockModel);
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
    public ResponseEntity<ResponseData> delete(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {
            strockMapper.delete(stockModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }


    /*
     * @Description :회수
     * */
    @Transactional
    public ResponseEntity<ResponseData> clear(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {

            if (stockModel.getBuil() == null)
                stockModel.setBuil("");

            if (stockModel.getTeam() == null)
                stockModel.setTeam("");

            if (stockModel.getFloor() == null)
                stockModel.setFloor("");

            if (stockModel.getPlace() == null)
                stockModel.setPlace("");

            if (stockModel.getUserNm() == null)
                stockModel.setUserNm("");

            if (stockModel.getIp() == null)
                stockModel.setIp("");

            if (stockModel.getYear() == null)
                stockModel.setYear("");

            if (stockModel.getHwp() == null)
                stockModel.setHwp("");

            if (stockModel.getMs() == null)
                stockModel.setMs("");

            if (stockModel.getMemo() == null)
                stockModel.setMemo("");

            strockMapper.clear(stockModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * @Description : 사용
     * */
    @Transactional
    public ResponseEntity<ResponseData> use(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {

            if (stockModel.getBuil() == null)
                stockModel.setBuil("");

            if (stockModel.getTeam() == null)
                stockModel.setTeam("");

            if (stockModel.getFloor() == null)
                stockModel.setFloor("");

            if (stockModel.getPlace() == null)
                stockModel.setPlace("");

            if (stockModel.getUserNm() == null)
                stockModel.setUserNm("");

            if (stockModel.getIp() == null)
                stockModel.setIp("");

            if (stockModel.getYear() == null)
                stockModel.setYear("");

            if (stockModel.getHwp() == null)
                stockModel.setHwp("");

            if (stockModel.getMs() == null)
                stockModel.setMs("");

            if (stockModel.getMemo() == null)
                stockModel.setMemo("");

            strockMapper.use(stockModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<ResponseData> excelExport(StockModel stockModel) {
        ResponseData res = new ResponseData();
        try {
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            res.setSystem();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
