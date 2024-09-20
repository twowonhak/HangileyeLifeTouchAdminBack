package com.hangileye.lifetouch.service.questionMain;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.questionMain.QueResultMapper;
import com.hangileye.lifetouch.model.common.ExcelModel;
import com.hangileye.lifetouch.model.questionMain.ExampleModel;
import com.hangileye.lifetouch.model.questionMain.QueResultModel;
import com.hangileye.lifetouch.model.questionMain.QuestionModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueResultService extends ErrorHistory {

    private final QueResultMapper queResultMapper;
    private final ErrorMapper errorMapper;

    public ResponseEntity<ResponseData> listSelect(HttpServletRequest request, QueResultModel queResultModel) {
        ResponseData res = new ResponseData();
        List<QuestionModel> resQueList = new ArrayList<>(queResultMapper.commonQuestionSelect());
        ArrayList<ExampleModel> resExaList = new ArrayList<>();
        QueResultModel queModel = new QueResultModel();
        List<QuestionModel> queList;
        List<ExampleModel> exaList;

        try {

            for (String lrgCtgCd : queResultModel.getLrgCtgCdArr()) {
                for (Map<String, String> map : queResultModel.getMidCtgCdArr()) {
                    for (String key : map.keySet()) {
                        if (lrgCtgCd.equals(key)) {
                            queModel.setLrgCtgCd(lrgCtgCd);
                            queModel.setMidCtgCd(map.get(key));
                            queList = queResultMapper.questionSelect(queModel);
                            resQueList.addAll(queList);
                        }
                    }
                }
            }


            resQueList.addAll(queResultMapper.lastQuestionSelect());


            for (QuestionModel qModel : resQueList) {
                exaList = queResultMapper.exampleSelect(qModel.getKey());
                resExaList.addAll(exaList);
            }

            resQueList.sort(Comparator.comparing(QuestionModel::getLrgCtgCd).thenComparing(QuestionModel::getMidCtgSort));

            Map<Object, Object> resMap = new HashMap<>();
            resMap.put("queList", resQueList);
            resMap.put("exaList", resExaList);

            res.setData(resMap);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

//    public ResponseEntity<ResponseData> stateExcelExport(HttpServletResponse response, HttpServletRequest request, ExcelModel stateModel) {
//        ResponseData res = new ResponseData();
//        try {
////            List<ExcelModel> list = queResultMapper.stateExcelExport(stateModel);
//            String[] list = queResultMapper.stateExcelExport(stateModel);
////            if (list.size() > 0) {
//            if (list.length > 0) {
//                String[] header = {"차트번호", "환자명", "성별", "나이", "방문일자", "진료과", "대분류명", "중분류명", "질문", "보기", "답변"};
//                Excel.ExcelExport(response, header, stateModel, list);
//                res.setSuccess();
//            } else {
//                res.setNoExcelData();
//            }
//            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
//        } catch (Exception e) {
//            return errorHistory(request, res, errorMapper, e);
//        }
//    }

    public String[] stateExcelExport(HttpServletResponse response, HttpServletRequest request, ExcelModel excelModel) {
        return queResultMapper.stateExcelExport(excelModel);
//            if (list.size() > 0) {

    }

}