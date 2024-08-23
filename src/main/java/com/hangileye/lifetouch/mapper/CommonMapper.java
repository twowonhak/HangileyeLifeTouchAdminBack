package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.common.AppointmentModel;
import com.hangileye.lifetouch.model.common.DiagModel;
import com.hangileye.lifetouch.model.common.MenuModel;
import com.hangileye.lifetouch.model.common.PatInfoModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonMapper {

    List<DiagModel> diagListSelect();

    PatInfoModel chartNoSelect(String chartNo);

    List<AppointmentModel> appointmentListSelect(String chartNo);

    List<MenuModel> mainMenuSelect(MenuModel menuModel);
}
