package com.hangileye.lifetouch.mapper.questionMain.dummy.response;

import com.hangileye.lifetouch.model.common.AppointmentModel;
import com.hangileye.lifetouch.model.questionMain.dummy.response.ResponseModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResponseMapper {
    List<ResponseModel> responseResultListSelect(AppointmentModel appointmentModel);
}
