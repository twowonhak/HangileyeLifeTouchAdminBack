package com.hangileye.lifetouch.service.stockMain.stock;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.stockMain.asset.AssetMapper;
import com.hangileye.lifetouch.mapper.stockMain.stock.StockMapper;
import com.hangileye.lifetouch.model.stockMain.stock.StockModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class StockService extends ErrorHistory {

    private final StockMapper stockMapper;
    private final AssetMapper assetMapper;
    private final ErrorMapper errorMapper;

    public StockService(StockMapper stockMapper, AssetMapper assetMapper, ErrorMapper errorMapper) {
        this.stockMapper = stockMapper;
        this.assetMapper = assetMapper;
        this.errorMapper = errorMapper;
    }

    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> listSelect(StockModel stockModel, HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            res.setData(stockMapper.listSelect(stockModel));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 공통코드
     * */
    @Transactional
    public ResponseEntity<ResponseData> cdListSelect(HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            Map map = new HashMap<>();
            map.put("assetMain", assetMapper.mainListSelect());
            map.put("assetSub", assetMapper.subListSelect());
            map.put("team", stockMapper.teamListSelect());
            map.put("code", stockMapper.codeListSelect());
            res.setData(map);
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
    public ResponseEntity<ResponseData> insert(StockModel stockModel, HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            stockMapper.insert(stockModel);
            res.setData(stockModel.getId());
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }


    /*
     * @Description : 목록 조회
     * */
    @Transactional
    public ResponseEntity<ResponseData> detailSelect(String id, HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            res.setData(stockMapper.detailSelect(id));
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 수정
     * */
    @Transactional
    public ResponseEntity<ResponseData> update(StockModel stockModel, HttpServletRequest request) {
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

            stockMapper.update(stockModel);
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
    public ResponseEntity<ResponseData> delete(StockModel stockModel, HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            stockMapper.delete(stockModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }


    /*
     * @Description :회수
     * */
    @Transactional
    public ResponseEntity<ResponseData> clear(StockModel stockModel, HttpServletRequest request) {
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

            stockMapper.clear(stockModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    /*
     * @Description : 사용
     * */
    @Transactional
    public ResponseEntity<ResponseData> use(StockModel stockModel, HttpServletRequest request) {
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

            stockMapper.use(stockModel);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseData> excelExport(StockModel stockModel, HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
