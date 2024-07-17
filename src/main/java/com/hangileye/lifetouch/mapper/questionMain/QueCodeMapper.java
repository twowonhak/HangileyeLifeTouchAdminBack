package com.hangileye.lifetouch.mapper.questionMain;

import com.hangileye.lifetouch.model.questionMain.QueCodeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueCodeMapper {

    List<QueCodeModel> lrgCtgListSelect();

    List<QueCodeModel> midCtgListSelect();

    void lrgCtgInsert(QueCodeModel queCodeModel);

    void migCtgInsert(QueCodeModel queCodeModel);

    void lrgCtgUpdate(QueCodeModel queCodeModel);

    void midCtgUpdate(QueCodeModel queCodeModel);

    void lrgCtgDelete(QueCodeModel queCodeModel);

    void midCtgDelete(QueCodeModel queCodeModel);

    void lrgCtgSortUpdate(QueCodeModel queCodeModel);

    void midCtgSortUpdate(QueCodeModel queCodeModel);
}
