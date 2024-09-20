package com.hangileye.lifetouch.service.stockMain.state;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.stockMain.state.StateMapper;
import com.hangileye.lifetouch.mapper.stockMain.stats.StatsMapper;
import com.hangileye.lifetouch.model.common.ExcelModel;
import com.hangileye.lifetouch.model.stockMain.state.StateModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class StateService extends ErrorHistory {

    private final StateMapper stateMapper;
    private final StatsMapper statsMapper;
    private final ErrorMapper errorMapper;

    public StateService(StateMapper stateMapper, StatsMapper statsMapper, ErrorMapper errorMapper) {
        this.stateMapper = stateMapper;
        this.statsMapper = statsMapper;
        this.errorMapper = errorMapper;
    }


    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, StateModel stateModel) {
        ResponseData res = new ResponseData();
        try {
            Map map = new HashMap<>();

            map.put("assetMain", statsMapper.mainListSelect());
            map.put("assetSub", stateMapper.listSelect(stateModel));

            res.setData(map);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    public String[] excelExport(HttpServletResponse response, HttpServletRequest request, ExcelModel excelModel) {
        return stateMapper.excelExport(excelModel);
    }
}
