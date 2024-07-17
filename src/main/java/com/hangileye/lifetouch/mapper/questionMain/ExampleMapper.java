package com.hangileye.lifetouch.mapper.questionMain;

import com.hangileye.lifetouch.model.questionMain.ExampleModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExampleMapper {

    List<ExampleModel> listSelect(String queKey);

    ExampleModel detailSelect(ExampleModel questionCaseModel);

    void insert(ExampleModel questionCaseModel);

    void delete(ExampleModel questionCaseModel);

    void update(ExampleModel questionCaseModel);

    void sortUpdate(ExampleModel exampleModel);

}
