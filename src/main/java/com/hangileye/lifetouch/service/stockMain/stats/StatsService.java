package com.hangileye.lifetouch.service.stockMain.stats;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.stockMain.stats.StatsMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StatsService extends ErrorHistory {

    private final StatsMapper statsMapper;
    private final ErrorMapper errorMapper;

    public StatsService(StatsMapper statsMapper, ErrorMapper errorMapper) {
        this.statsMapper = statsMapper;
        this.errorMapper = errorMapper;
    }

    @Transactional
    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request) {
        ResponseData res = new ResponseData();
        try {

            Map map = new HashMap<>();
            Map sMap = new HashMap<>();
            Map lMap = new HashMap<>();

            sMap.put("assetMain", statsMapper.mainListSelect());
            sMap.put("assetSub", statsMapper.subListSelect());

            lMap.put("dis", statsMapper.disLicenseListSelect());
            lMap.put("doc", statsMapper.docLicenseListSelect());

            map.put("stock", sMap);
            map.put("license", lMap);

            res.setData(map);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
