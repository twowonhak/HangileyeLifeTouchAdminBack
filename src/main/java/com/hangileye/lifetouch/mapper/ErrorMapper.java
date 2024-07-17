package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.ErrorModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ErrorMapper {

    void insertErrorHis(ErrorModel errorModel);

}
