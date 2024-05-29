package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.common.CodeModel;
import com.hangileye.lifetouch.model.common.DiagModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeMapper {

    List<CodeModel> diag();
}
