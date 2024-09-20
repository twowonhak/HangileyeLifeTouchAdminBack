package com.hangileye.lifetouch.mapper.stockMain.state;

import com.hangileye.lifetouch.model.common.ExcelModel;
import com.hangileye.lifetouch.model.stockMain.state.StateModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StateMapper {

    List<StateModel> listSelect(StateModel stateModel);

    String[] excelExport(ExcelModel excelModel);
}
